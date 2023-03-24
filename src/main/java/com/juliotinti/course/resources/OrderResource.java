package com.juliotinti.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliotinti.course.entities.Order;
import com.juliotinti.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){  //ResponseEntities é um tipo Spring para retornar respostas de requisições Web
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); //o body é para você colocar o q está em parenteses no corpo (na tela) da requisição
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){ //PathVariable é para que o parâmetro seja a variavel da requisição, no caso {id} 
		Order order = service.finalById(id);
		return ResponseEntity.ok().body(order); 
	}

}
