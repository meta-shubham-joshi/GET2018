package com.facade;

import com.dao.UserOperation;
import com.model.UserPOJO;

/**
 * Class for transfering the email and password to the dao layer and giving back the result to the controller.
 */
public class LoginFacade {

	// Implementing the singleton pattern i.e. creating a single object of the class.
		private static LoginFacade loginFacade = new LoginFacade();
		
		// Method giving the single instance of the class.
		public static LoginFacade getInstance(){
			return loginFacade;
		}
		
		/**
		 * Method checking the login credentials.
		 * @param email email of the user.
		 * @param password password of the user.
		 * @return whether the email and password provided is correct or not to login into the system.
		 */
		public boolean  checkValidityFromDatabase(String email,String password){
			UserOperation userOperation = new UserOperation();
			
			return userOperation.checkValidLoginCredentials(email, password);

		}
}
