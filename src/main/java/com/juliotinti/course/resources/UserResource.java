package com.juliotinti.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juliotinti.course.entities.User;
import com.juliotinti.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping //para conseguir usar o Ger no postman
	public ResponseEntity<List<User>> findAll(){  //ResponseEntities é um tipo Spring para retornar respostas de requisições Web
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //o body é para você colocar o q está em parenteses no corpo (na tela) da requisição
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ //PathVariable é para que o parâmetro seja a variavel da requisição, no caso {id} 
		User user = service.finalById(id);
		return ResponseEntity.ok().body(user); 
	}
	
	@PostMapping //para conseguir usar o Post no postman
	public ResponseEntity<User> insert(@RequestBody User user){ //RequestBody é para deserializar um objeto JSON para objeto User
		user = service.insert(user);
		//temos que construir esse URI para que o próprio postman nos mostre em qual caminho está o objeto inserido, para vermos no web
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user); 
	}
	
	@DeleteMapping(value = "/{id}") //para usar o Delete no postman
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") //para conseguir atualizar dados pelo método http
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);
	}

}
