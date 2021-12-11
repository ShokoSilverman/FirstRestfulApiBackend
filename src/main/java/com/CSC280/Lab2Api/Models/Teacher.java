package com.CSC280.Lab2Api.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Teacher{
	@Getter
	@Setter
	@Id
	private String id;
	private String classTaught;
	private String firstName;
	private String lastName;


	public Teacher(String id, String firstName, String lastName, String classTaught) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.classTaught = classTaught;
	}

	public Teacher(String classTaught, String firstName, String lastName) {
		this.classTaught = classTaught;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Teacher(){}



	public Teacher(String classTaught) {
		this.classTaught = classTaught;
	}

	public String getClassTaught() {
		return classTaught;
	}

	public void setClassTaught(String classTaught) {
		this.classTaught = classTaught;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", firstName= " + firstName + ", lastName= "
				+ lastName + ", classTaught= " + classTaught + "]";
	}

	public void upTeacher(String firstName, String lastName, String classTaught) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.classTaught = classTaught;
	}
	
	
	
}
