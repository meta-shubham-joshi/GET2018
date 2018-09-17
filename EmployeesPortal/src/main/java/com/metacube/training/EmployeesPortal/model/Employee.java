package com.metacube.training.EmployeesPortal.model;

import java.sql.Date;

public class Employee {
	
	private String empCode;
	private String firstName;
	private String lastName;
	private Date dob;
	private String  gender;
	private String  primary_contact_number;
	private String  secondary_contact_number;
	private String  email_id;
	private String skype_id;
	private String profile_picture;
	private String  password;
	private boolean enabled=true;
	
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrimary_contact_number() {
		return primary_contact_number;
	}
	public void setPrimary_contact_number(String primary_contact_number) {
		this.primary_contact_number = primary_contact_number;
	}
	public String getSecondary_contact_number() {
		return secondary_contact_number;
	}
	public void setSecondary_contact_number(String secondary_contact_number) {
		this.secondary_contact_number = secondary_contact_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getSkype_id() {
		return skype_id;
	}
	public void setSkype_id(String skype_id) {
		this.skype_id = skype_id;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean dEFAULT) {
		this.enabled = dEFAULT;
	}

}
