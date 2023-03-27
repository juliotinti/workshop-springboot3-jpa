package com.juliotinti.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliotinti.course.entities.User;
import com.juliotinti.course.repositories.UserRepository;

@Service //para registrar a classe como componente do Spring, possibilitando o mecanismo de injeção de dependencia do Spring
public class UserService {
	
	@Autowired //isso faz com que o Spring organize essa dependência
	private UserRepository repository; 
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User finalById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
	
	
}
