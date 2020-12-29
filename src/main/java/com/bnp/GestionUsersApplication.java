package com.bnp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bnp.dao.UserRepository;
import com.bnp.entities.User;



@SpringBootApplication
public class GestionUsersApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(GestionUsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//AJOUTER DES USERS
		userRepository.save(new User("lynda","lynda@gmail.com", "lynda"));
		userRepository.save(new User("tibari", "tibari@gmail.com", "tibari"));
		userRepository.save(new User("Tarik","tarik@gmail.com","tarik"));
		for(int i=0;i<2000;i++) {
			userRepository.save(new User("login"+i, "email"+i+"@gmail.com", "tototiti"+i));
		}
		
		System.out.println("=============================get All User login=====================");
		userRepository.findAll().forEach(u->{
			System.out.println(u.getLogin());
		});
		
		System.out.print("===================find one==========================");
		User user=userRepository.findById(1L).get();
		System.out.println(user.getLogin());
	}

}
