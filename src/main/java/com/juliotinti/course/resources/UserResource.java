package com.juliotinti.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliotinti.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){  //ResponseEntities é um tipo Spring para retornar respostas de requisições Web
		User u = new User(1L, "Maria", "maria@gmail.com", "(99)99999-9999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
