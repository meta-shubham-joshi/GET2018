package com.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.JDBCConnection;
import com.dao.Query;
import com.dao.UserOperation;
import com.model.UserPOJO;

public class RegisterFacade {
	
	// Implementing the singleton pattern i.e. creating a single object of the class.
	private static RegisterFacade registerFacade = new RegisterFacade();
	
	// Method giving the single instance of the class.
	public static RegisterFacade getInstance(){
		return registerFacade;
	}
	
	public boolean  addToDatabase(UserPOJO userdetails){
		UserOperation userOperation = new UserOperation();
		
		return userOperation.addUser(userdetails);

	}
}