package com.app.service;

import com.app.entities.Users;

public interface UsersService {
	
	
	    Users createUser(Users user, String password);
	    boolean isUserValid(String userName, String password);
	    
		

}
