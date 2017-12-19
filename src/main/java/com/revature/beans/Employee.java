package com.revature.beans;

public class Employee {
	private int id;
	private String userName;
	private String pass;
	private String firstName;
	private String lastName;
	private String role;
	
	public Employee(int id, String userName, String pass, String firstName, String lastName, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", pass=" + pass + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", role=" + role + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
