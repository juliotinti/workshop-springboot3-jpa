package com.juliotinti.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliotinti.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
