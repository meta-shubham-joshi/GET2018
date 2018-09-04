package com.facade;

import java.sql.Date;

import com.dao.UserOperation;

public class EditFacade {

	// Implementing the singleton pattern i.e. creating a single object of the
	// class.
	private static EditFacade editFacade = new EditFacade();

	// Method giving the single instance of the class.
	public static EditFacade getInstance() {
		return editFacade;
	}

	/**
	 * Method checking the login credentials.
	 * 
	 * @param email
	 *            email of the user.
	 * @param password
	 *            password of the user.
	 * @return whether the email and password provided is correct or not to
	 *         login into the system.
	 */
	public boolean updateUserDetailsInDatabase(String firstName,
			String lastName, int age, String contactNo, Date date,String email) {
		UserOperation userOperation = new UserOperation();

		return userOperation.updateUserDetails(firstName, lastName, age,
				contactNo, date, email);

	}

}
