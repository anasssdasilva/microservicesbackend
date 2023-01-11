package com.tasshilat.users.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasshilat.users.beans.CounterConnections;
import com.tasshilat.users.beans.Login;
import com.tasshilat.users.beans.Roles;
import com.tasshilat.users.beans.User;
import com.tasshilat.users.repository.CounterRepository;
import com.tasshilat.users.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@PostMapping("/save")
	public void save(@RequestBody User user){
		if(user.getId()==0) {
		    user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		userRepository.save(user);
	}
	
	
	
	@GetMapping("/all")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) String id){
		userRepository.deleteById(Integer.parseInt(id));
	}
	
	@GetMapping("/{id}")
	public Optional<User> getOne(@PathVariable(required =true) String id){
		return userRepository.findById(Integer.parseInt(id));
	}
	
	@GetMapping("/allUsers")
	public Optional<List<User>> getAllUsers(){
		return userRepository.findAllUsers();
	}
		
	
	@PostMapping("/check")
	public Roles check(@RequestBody Login login){
		Roles role = new Roles(-1,false);
		Optional<User> user = userRepository.findByEmail((String) login.getEmail());
		if(!user.isEmpty()) {
			BCryptPasswordEncoder b = new BCryptPasswordEncoder();
			String enteredPassword = login.getPassword();
			String realPassword = user.get().getPassword();
			if(b.matches(enteredPassword, realPassword)) {
				role = new Roles(user.get().getId(),user.get().getRole());
			}
		}		
		return role;
	}
	
	
	@PostMapping("/sendemail")
	public String sendEmail(@RequestBody User user) {
		try {
			sendmail(user);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Email sent successfully";
	}

	private void sendmail(User user) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tasshilatensaj@gmail.com", "tasshilatensaj1.");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("tasshilatensaj@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		msg.setSubject("TASSHILAT ENSAJ");
		msg.setContent("<b>Dear "+user.getLastName()+"</b>,<br><i>TASSHILAT ENSAJ is welcoming you </i>"
		        + "<br>Your login credentials are the following:<br>"
		        + "<b>Email:</b> "+user.getEmail()
		        + "<br><b>Password:</b> "+user.getPassword()
		        + "<br><b>Best Regards</b><br>"
		        + "TASSHILAT ENSAJ team 2021", "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("TASSHILAT ENSAJ", "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		Transport.send(msg);
	}
}
