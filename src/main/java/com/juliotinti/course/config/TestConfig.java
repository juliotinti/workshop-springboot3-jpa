package com.juliotinti.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.juliotinti.course.entities.User;
import com.juliotinti.course.repositories.UserRepository;

//para avisar ao Java que é uma classe de configuração
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired //isso faz com que o Spring organize essa dependência
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//tudo que você colocar aqui vai ser executado quando a aplicação for iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		//quem acessa o banco de dados do User é o UserRepository
		userRepository.saveAll(Arrays.asList(u1, u2)); //isso salva uma lista no db
		
	}
	
	
}
