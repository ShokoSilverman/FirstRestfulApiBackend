package com.CSC280.Lab2Api.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Degree {

	@Id
	private String id;
	private String name;
	private String chair;


	public Degree(String id, String name, String chair) {
		this.id = id;
		this.name = name;
		this.chair = chair;
	}

	public Degree(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChair() {
		return chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", chair=" + chair + "]";
	}
	
	public void upDegree(String name, String chair) {
		this.name = name;
		this.chair = chair;
	}

	
	
	
}
