package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.model.UserPOJO;

public class UserOperation {

	/**
	 * Method to add the user details to the database.
	 * @param userDetails containg the details of the user.
	 * @return true if result is added else return false.
	 */
	public boolean addUser(UserPOJO userDetails) {

		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");
		boolean returnValue = false;
		int result = 0;

		try {
			Query query = new Query();

			String queryForAddingUser = query.addUser();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForAddingUser);

			preparedstatement.setString(1, userDetails.getEmail());
			preparedstatement.setString(2, userDetails.getFirstName());
			preparedstatement.setString(3, userDetails.getLastName());
			preparedstatement.setInt(4, userDetails.getAge());
			preparedstatement.setString(5, userDetails.getContactNo());
			preparedstatement.setDate(6, userDetails.getDate());
			preparedstatement.setString(7, userDetails.getPassword());
			preparedstatement.setString(8, userDetails.getConfirmPassword());
			preparedstatement.setString(9, userDetails.getOrganization());
			preparedstatement.setString(10, userDetails.getImageURL());

			result = preparedstatement.executeUpdate();

			if (result > 0) {
				returnValue = true;
			} else {
				System.out.println("!!Error!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return returnValue;

	}
	
	/**
	 * Method to check whether the credentials provided is right or wrong.
	 * @param email of the user.
	 * @param password of the user.
	 * @return true if credentials are correct else return false.
	 */
	public boolean checkValidLoginCredentials(String email,String password){
		
		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");
		boolean returnValue = false;
		int result = 0;

		try {
			Query query = new Query();

			String queryForCheckValidLoginCredentials = query.checkValidLoginCredentials();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForCheckValidLoginCredentials);

			preparedstatement.setString(1, email);
			ResultSet resultset = preparedstatement.executeQuery();
			
			if (resultset.next()) {
				returnValue = true;
			} else {
				System.out.println("!!Error!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return returnValue;
		
	}
	
	public UserPOJO getUserDetailsByEmail(String email){
		
		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");

		UserPOJO userDetailsByEmail = null;
		int result = 0;

		try {
			Query query = new Query();

			String queryForGettingUserDetailsByEmail = query.getUserDetailsByEmail(email);

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForGettingUserDetailsByEmail);

			preparedstatement.setString(1, email);
			ResultSet resultset = preparedstatement.executeQuery();
			
			
			
			if (resultset.next()) {
				
				System.out.println(resultset.getString("Email"));
				System.out.println(resultset.getString("Organization"));
				
				userDetailsByEmail= new UserPOJO(resultset.getString("FirstName"),resultset.getString("LastName"),resultset.getInt("Age"),resultset.getString("ContactNumber"),resultset.getDate("Date"),resultset.getString("Email"),resultset.getString("Password"),resultset.getString("ConfirmPassword"),resultset.getString("Organization"),resultset.getString("Image_Url"));
				return userDetailsByEmail;
			} else {
				System.out.println("!!Error!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return userDetailsByEmail;
		
	}

	public boolean updateUserDetails(String firstName,String lastName,int age,String contactNo, Date date,String email) {
		
		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");

		int result = 0;
		boolean returnVal = false;

		try {
			Query query = new Query();

			String queryForUpdateUserDetails = query.updateUserDetailsForEdit();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForUpdateUserDetails);

			preparedstatement.setString(1, firstName);
			preparedstatement.setString(2, lastName);
			preparedstatement.setInt(3,  age);
			preparedstatement.setString(4, contactNo);
			preparedstatement.setDate(5, date);
			preparedstatement.setString(6, email);
			
			result = preparedstatement.executeUpdate();
			
			if (result>0) {
				returnVal = true;
				return returnVal;
			} else {
				System.out.println("!!Error!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return returnVal;
	}

	public ArrayList<UserPOJO> giveUserFriends(String organization) {
		
		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");

		ArrayList<UserPOJO> userDetailsByEmail = new ArrayList<UserPOJO>();

		try {
			Query query = new Query();

			String queryForGettingUserFriends = query.gettingUserFriends();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForGettingUserFriends );

			preparedstatement.setString(1, organization);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()){
				while (resultset.next()) {
					userDetailsByEmail.add(getUserDetailsByEmail(resultset.getString("Email")));
			}
			} else {
				System.out.println("!!Error Organization Name Given Is Incorrect!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return userDetailsByEmail;
	}

	public boolean addImageToDatabase(String email, String url) {
		
		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"UserDetails", "root", "papaji@028");

		boolean returnVal = false;

		try {
			Query query = new Query();

			String queryForStoringImageURLByEmail = query.storingImageURLOfUser();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForStoringImageURLByEmail );

			preparedstatement.setString(1, url);
			preparedstatement.setString(2, email);
			
			int result = preparedstatement.executeUpdate();
			
			if(result>0){
				returnVal = true;
				return returnVal;
			}
		    else {
				System.out.println("!!Invalid Email given!!");

			}

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return returnVal;
		
	
	}
}
