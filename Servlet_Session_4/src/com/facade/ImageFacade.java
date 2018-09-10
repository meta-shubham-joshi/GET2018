package com.facade;

import java.util.ArrayList;

import com.dao.UserOperation;
import com.model.UserPOJO;
import com.oreilly.servlet.MultipartRequest;

public class ImageFacade {
	
	// Implementing the singleton pattern i.e. creating a single object of the
			// class.
			private static ImageFacade imageFacade = new ImageFacade();

			// Method giving the single instance of the class.
			public static ImageFacade getInstance() {
				return imageFacade;
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
			public boolean addImageURLToDatabase(String email, String url) {
				
				UserOperation userOperation = new UserOperation();

				return userOperation.addImageToDatabase(email, url );

			}

}
