package com.tasshilat.tva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasshilat.tva.beans.CountOperation;
import com.tasshilat.tva.beans.CountOperator;
import com.tasshilat.tva.beans.Tva;
import com.tasshilat.tva.repository.TvaRepository;



@RestController
@RequestMapping("tva")
public class TvaController {
	
	@Autowired
	private TvaRepository tvaRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Tva tva){
		tvaRepository.save(tva);
	}
	
	@GetMapping("/all")
	public List<Tva> findAll(){
		return tvaRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) String id){
		tvaRepository.deleteById(Integer.parseInt(id));
	}
	
	@GetMapping("/{id}")
	public Optional<Tva> getOne(@PathVariable(required =true) String id){
		return tvaRepository.findById(Integer.parseInt(id));
	}
	
	@GetMapping("all/{id}")
	public List<Tva> findAllById(@PathVariable(required =true) String id){
		return tvaRepository.findAllById(Integer.parseInt(id));
	}
	
	@PostMapping("/count")
	public int getCount(@RequestBody int id){
		return tvaRepository.getCount(id);
	}
	@GetMapping("/countTva")
	public List<CountOperation> countUserByOp(){
		return tvaRepository.countUserByOp();
	}
	@GetMapping("/countT")
	public int countFacture(){
		return tvaRepository.countOp();
	}
	@GetMapping("/countOperator")
	public List<CountOperator> countOperByOperator(){
		return tvaRepository.countOperByOperator();
	}
	
}
