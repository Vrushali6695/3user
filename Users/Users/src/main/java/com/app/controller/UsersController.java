package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Users;
import com.app.service.UsersService;

@RestController
@RequestMapping("/users")
	public class UsersController {
	    private final UsersService usersService;

	    @Autowired
	    public UsersController(UsersService usersService) {
	        this.usersService = usersService;
	    }

	    @PostMapping("/{password}")
	    public Users createUser(@RequestBody Users user, @PathVariable String password) {
	        user.setPassword(password); // Plain password received from the request
	        return usersService.createUser(user, password);
	    }

	    @GetMapping("/{userName}/{password}")
	    public String validateUser(@PathVariable String userName, @PathVariable String password) {
	        boolean isValid = usersService.isUserValid(userName, password);
	        return isValid ? "Valid user" : "Invalid user";
	    }

	    
	

}
