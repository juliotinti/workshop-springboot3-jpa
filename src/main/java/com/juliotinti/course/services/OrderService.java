package com.juliotinti.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliotinti.course.entities.Order;
import com.juliotinti.course.repositories.OrderRepository;

@Service //para registrar a classe como componente do Spring, possibilitando o mecanismo de injeção de dependencia do Spring
public class OrderService {
	
	@Autowired //isso faz com que o Spring organize essa dependência
	private OrderRepository repository; 
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order finalById(long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	

}
