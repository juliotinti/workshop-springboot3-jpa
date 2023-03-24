package com.juliotinti.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliotinti.course.entities.Category;
import com.juliotinti.course.repositories.CategoryRepository;

@Service //para registrar a classe como componente do Spring, possibilitando o mecanismo de injeção de dependencia do Spring
public class CategoryService {
	
	@Autowired //isso faz com que o Spring organize essa dependência
	private CategoryRepository repository; 
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category finalById(long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	

}
