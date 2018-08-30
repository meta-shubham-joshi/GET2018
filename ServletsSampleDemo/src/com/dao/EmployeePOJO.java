package com.dao;

/**
 * POJO Class for Employee Information.
 */
public class EmployeePOJO {

	private String firstName;
	private String lastName;
	private String email;
	private int age;

	/**
	 * Constructor for initialising the details of the Employee.
	 * 
	 * @param firstName
	 *            firstname of the user.
	 * @param lastName
	 *            lastname of the user.
	 * @param email
	 *            email of the user.
	 * @param age
	 *            age of the user.
	 */
	public EmployeePOJO(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	/**
	 * Method to get First Name.
	 * 
	 * @return first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method to set First Name.
	 * 
	 * @param firstName
	 *            first name of the user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method to get Last Name.
	 * 
	 * @return last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method to set the Last Name.
	 * 
	 * @param lastName
	 *            last name of the user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to get Email.
	 * 
	 * @return email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method to set email of the user.
	 * 
	 * @param email
	 *            email of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method to get Age.
	 * 
	 * @return age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Method to set the age of the user.
	 * 
	 * @param age
	 *            age of the user.
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
