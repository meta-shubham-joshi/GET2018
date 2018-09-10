package com.facade;

import com.dao.UserOperation;
import com.model.UserPOJO;

public class UserFacade {

	// Implementing the singleton pattern i.e. creating a single object of the
	// class.
	private static UserFacade userFacade = new UserFacade();

	// Method giving the single instance of the class.
	public static UserFacade getInstance() {
		return userFacade;
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
	public UserPOJO gettingUserDetailsFromDatabase(String email) {
		UserOperation userOperation = new UserOperation();

		return userOperation.getUserDetailsByEmail(email);

	}

}
