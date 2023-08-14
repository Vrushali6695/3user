package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUserName(String userName);
}
