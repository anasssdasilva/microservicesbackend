package com.tasshilat.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasshilat.users.beans.CountConnections;
import com.tasshilat.users.beans.CounterConnections;
import com.tasshilat.users.repository.CounterRepository;

@RestController
@RequestMapping("counter")
public class CounterController {
	
	@Autowired
	private CounterRepository CounterRepository;
	
	@PostMapping("/save")
	public void addCounter(@RequestBody CounterConnections counterConnections){
		CounterRepository.save(counterConnections);
	}
	
	@GetMapping("/all")
	public List<CounterConnections> getAll(){
		return CounterRepository.findAll();
	}
	
	@GetMapping("/connections")
	public List<CountConnections> findConnectionsByDate(){
		return CounterRepository.findConnectionsByDate();
	}


}
