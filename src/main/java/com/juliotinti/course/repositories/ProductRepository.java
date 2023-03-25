package com.juliotinti.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliotinti.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
