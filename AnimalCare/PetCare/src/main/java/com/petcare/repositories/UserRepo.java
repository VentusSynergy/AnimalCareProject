package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
