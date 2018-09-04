package com.dao;

/**
 * Class for Query of the application.
 */
public class Query {

	/**
	 * Method having query to add Employee.
	 * @return query for adding employee.
	 */
	public String addUser() {
		return "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Method having query to check whether the credentials provided is right or wrong.
	 * @return query for checking credentials validity.
	 */
	public String checkValidLoginCredentials(){
		return "SELECT Password FROM USER WHERE Email= ?";
	}

	public String getUserDetailsByEmail(String email) {
		return "SELECT * FROM USER WHERE Email= ?";
	}

	public String updateUserDetailsForEdit() {
		
		return "UPDATE USER SET FirstName= ?, LastName= ?, Age= ?, ContactNumber= ?, Date= ? WHERE Email=?";
	}

	public String gettingUserFriends() {
		
		return "SELECT Email FROM USER WHERE Organization= ?";
	}

	public String storingImageURLOfUser() {
		
		return "UPDATE USER SET Image_Url = ? WHERE Email=?";
	}
}
