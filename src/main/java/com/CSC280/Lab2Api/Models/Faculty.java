package com.CSC280.Lab2Api.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty{

	@Getter
	@Setter
	@Id
	private String id;
	private String jobTitle;
	private String firstName;
	private String lastName;


	public Faculty(String id, String jobTitle, String firstName, String lastName) {
		this.id = id;
		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Faculty(String jobTitle, String firstName, String lastName) {
		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Faculty(){}


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "[id= " + id + ", firstName= " + firstName + ", lastName= " + lastName
				+ ",jobTitle= " + jobTitle + "]";
	}
	
	public void upFaculty(String firstName, String lastName, String jobTitle) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
