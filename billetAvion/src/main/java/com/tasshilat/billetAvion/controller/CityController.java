package com.tasshilat.billetAvion.controller;

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

import com.tasshilat.billetAvion.beans.City;
import com.tasshilat.billetAvion.repository.CityRepository;

@RestController
@RequestMapping("citys")
public class CityController {
	@Autowired
	private CityRepository cityRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody City city){
		cityRepository.save(city);
	}
	
	@GetMapping("/all")
	public List<City> findAll(){
		return cityRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) String id){
		cityRepository.deleteById(Integer.parseInt(id));
	}
	
	@GetMapping("/{id}")
	public Optional<City> getOne(@PathVariable(required =true) String id){
		return cityRepository.findById(Integer.parseInt(id));
	}
}
