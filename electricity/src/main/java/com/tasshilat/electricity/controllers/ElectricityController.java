package com.tasshilat.electricity.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasshilat.electricity.beans.CountOperation;
import com.tasshilat.electricity.beans.Electricity;
import com.tasshilat.electricity.repositories.ElectricityRepository;



@RestController
@RequestMapping("facture")
public class ElectricityController {
	@Autowired
	private ElectricityRepository  ElectricityRepository;

	@GetMapping("/all")
	public List<Electricity> findAll() {
		return  ElectricityRepository.findAll();

}
	@PostMapping("/save")
	public void save(@RequestBody Electricity facture) {
		 ElectricityRepository.save(facture);
	}
	@GetMapping("/factureByContrat/{numContrat}")
	public List<Electricity> findFactureByContrat(@PathVariable String numContrat){
		return  ElectricityRepository.findFactureByContrat(numContrat);
	}
	@GetMapping("/countFacture")
	public List<CountOperation> countUserByOp(){
		return  ElectricityRepository.countUserByOp();
	}
	@GetMapping("/countF")
	public int countFacture(){
		return  ElectricityRepository.countOp();
	}
	
	@GetMapping("/{id}")
	public Optional<Electricity> getOne(@PathVariable(required =true) String id){
		return  ElectricityRepository.findById(Integer.parseInt(id));
	}
	
	@GetMapping("all/{id}")
	public List<Electricity> findAllById(@PathVariable(required =true) String id){
		return  ElectricityRepository.findAllById(Integer.parseInt(id));
	}

}
