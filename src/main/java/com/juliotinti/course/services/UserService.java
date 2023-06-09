package com.juliotinti.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.juliotinti.course.entities.User;
import com.juliotinti.course.repositories.UserRepository;
import com.juliotinti.course.services.exceptions.DatabaseException;
import com.juliotinti.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service //para registrar a classe como componente do Spring, possibilitando o mecanismo de injeção de dependencia do Spring
public class UserService {
	
	@Autowired //isso faz com que o Spring organize essa dependência
	private UserRepository repository; 
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User finalById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //orElseThrow tenta fazer o get, se n tiver usuário, ele lança uma exceção
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, user);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
	
	
}
