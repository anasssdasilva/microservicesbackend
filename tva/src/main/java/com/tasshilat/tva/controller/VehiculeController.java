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

import com.tasshilat.tva.beans.Vehicule;
import com.tasshilat.tva.repository.VehiculeRepository;

@RestController
@RequestMapping("vehicules")
public class VehiculeController {
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Vehicule vehicule){
		vehiculeRepository.save(vehicule);
	}
	
	@GetMapping("/all")
	public List<Vehicule> findAll(){
		return vehiculeRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) String id){
		vehiculeRepository.deleteById(Integer.parseInt(id));
	}
	
	@GetMapping("/{id}")
	public Optional<Vehicule> getOne(@PathVariable(required =true) String id){
		return vehiculeRepository.findById(Integer.parseInt(id));
	}
}
