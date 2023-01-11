package com.tasshilat.billetAvion.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<BilletAvion> billetAvion;
	
	public City() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BilletAvion> getbilletAvion() {
		return billetAvion;
	}

	public void setBilletAvion(List<BilletAvion> billetAvion) {
		this.billetAvion = billetAvion;
	}

	
	
}
