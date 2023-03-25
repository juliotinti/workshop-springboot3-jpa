package com.juliotinti.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliotinti.course.entities.Product;
import com.juliotinti.course.repositories.ProductRepository;

@Service //para registrar a classe como componente do Spring, possibilitando o mecanismo de injeção de dependencia do Spring
public class ProductService {
	
	@Autowired //isso faz com que o Spring organize essa dependência
	private ProductRepository repository; 
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product finalById(long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	

}
