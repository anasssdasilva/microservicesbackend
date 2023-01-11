package com.tasshilat.billetAvion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasshilat.billetAvion.beans.CountOperation;
import com.tasshilat.billetAvion.beans.CountCity;
import com.tasshilat.billetAvion.beans.City;
import com.tasshilat.billetAvion.beans.BilletAvion;
import com.tasshilat.billetAvion.repository.BilletAvionRepository;



@RestController
@RequestMapping("billetAvion")
public class BilletAvionController {
	
	@Autowired
	private BilletAvionRepository billetAvionRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody BilletAvion billetAvion){
		billetAvionRepository.save(billetAvion);
	}
	
	@GetMapping("/all")
	public List<BilletAvion> findAll(){
		return billetAvionRepository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		billetAvionRepository.deleteById(Integer.parseInt(id));

	}
	
	@GetMapping("/{id}")
	public Optional<BilletAvion> getOne(@PathVariable(required =true) String id){
		return billetAvionRepository.findById(Integer.parseInt(id));
	}
	
	@GetMapping("all/{id}")
	public List<BilletAvion> findAllById(@PathVariable(required =true) String id){
		return billetAvionRepository.findAllById(Integer.parseInt(id));
	}
	
	@PostMapping("/count")
	public int getCount(@RequestBody int id){
		return billetAvionRepository.getCount(id);
	}
	@GetMapping("/countBill")
	public List<CountOperation> countUserByOp(){
		return billetAvionRepository.countUserByOp();
	}
	@GetMapping("/countB")
	public int countFacture(){
		return billetAvionRepository.countOp();
	}
	@GetMapping("/countCity")
	public List<CountCity> countOperByCity(){
		return billetAvionRepository.countOperByCity();
	}
	
}
