package com.facade;

import java.sql.Date;
import java.util.ArrayList;

import com.dao.UserOperation;
import com.model.UserPOJO;

public class FriendsFacade {

	// Implementing the singleton pattern i.e. creating a single object of the
		// class.
		private static FriendsFacade friendsFacade = new FriendsFacade();

		// Method giving the single instance of the class.
		public static FriendsFacade getInstance() {
			return friendsFacade;
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
		public ArrayList<UserPOJO> giveUserFriendsFromDatabase(String organization) {
			
			UserOperation userOperation = new UserOperation();

			return userOperation.giveUserFriends(organization);

		}
}
