package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Users;
import com.app.repository.UsersRepository;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	 private final UsersRepository usersRepository;
	  private final BCryptPasswordEncoder passwordEncoder;

	    @Autowired
	    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
	        this.usersRepository = usersRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public Users createUser(Users user, String password) {
	        user.setPassword(passwordEncoder.encode(password));
	        return usersRepository.save(user);
	    }

	    @Override
	    public boolean isUserValid(String userName, String password) {
	        Users user = usersRepository.findByUserName(userName);
	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	            return true; 
	        }
	        return false; 
	    }

	
}
