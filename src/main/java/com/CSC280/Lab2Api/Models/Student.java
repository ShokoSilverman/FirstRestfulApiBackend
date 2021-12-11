package com.CSC280.Lab2Api.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Student{

	@Getter
	@Setter
	@Id
	private String id;
	private String favoriteClass;
	private String firstName;
	private String lastName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private Parent parent;


	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Student(String id, String firstName, String lastName, String favoriteClass) {
		this.favoriteClass = favoriteClass;
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public Student(String favoriteClass, String firstName, String lastName) {
		this.favoriteClass = favoriteClass;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student() {}


	public String getFavoriteClass() {
		return favoriteClass;
	}

	public void setFavoriteClass(String favoriteClass) {
		this.favoriteClass = favoriteClass;
	}

	@Override
	public String toString() {
		return "[id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", favoriteClass= " + favoriteClass + "]";
	}
	
	public void updateStudent(String firstName, String lastName, String favoriteClass) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoriteClass = favoriteClass;
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
