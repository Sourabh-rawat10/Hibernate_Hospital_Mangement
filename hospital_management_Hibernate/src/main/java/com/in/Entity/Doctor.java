package com.in.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialty;
	public Doctor(int id, String name, String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + "]";
	}
    
    
}
