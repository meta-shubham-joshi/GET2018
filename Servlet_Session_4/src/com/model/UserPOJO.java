package com.model;

import java.sql.Date;

/**
 * User POJO for the fields of user. 
 */
public class UserPOJO {
	
	private String firstName;
	private String lastName;
	private int age;
	private String contactNo;
	private Date date;
	private String email;
	private String password;
	private String confirmPassword;
	private String organization;
	private String image_url;
	
	/**
	 * Constructor initialising the user fields.
	 * @param firstName firstname of the user.
	 * @param lastName lastname of the user.
	 * @param age age of the user.
	 * @param contactNo contact number of the user.
	 * @param date date of the user.
	 * @param email email of the user.
	 * @param password password of the user.
	 * @param confirmPassword confirrm password field of the user.
	 */
	public UserPOJO(String firstName, String lastName, int age, String contactNo, Date date, String email, String password, String confirmPassword, String organization, String image_url){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNo = contactNo;
		this.date = date;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.organization = organization;
		this.image_url = image_url;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getImageURL() {
		return image_url;
	}

	public void setImageURL(String image_url) {
		this.image_url = image_url;
	}
	

}
