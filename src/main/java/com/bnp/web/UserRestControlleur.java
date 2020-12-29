package com.bnp.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bnp.dao.UserRepository;
import com.bnp.entities.User;

@RestController
@RequestMapping(path = "/api")
public class UserRestControlleur {

	 @Autowired
	private UserRepository userRepository;
	 
	 @GetMapping(value="/users")
	 public List<User> findAll(){
		 
		 return userRepository.findAll();
	 }
	 
	 //localhost:8080/api/users/2
	 @GetMapping(value="/users/{id}")
	 public User findOne(@PathVariable Long id) {
		 
		 return userRepository.findById(id).get();
	 }
	 
	 @PostMapping(value="/users")
	 public User addUser(@RequestBody User user) {
		return  userRepository.save(user);
	 }
	 
	 @DeleteMapping(value="/users/{id}")
	 public void deleteUser(@PathVariable Long id) {
		 userRepository.deleteById(id);
	 }
	 
	 
	 @PutMapping(path="/users/{id}")
	    public ResponseEntity<User> updateContact(@PathVariable(value="id") Long id,@RequestBody User user)
	          throws ResourceNotFoundException {
	         User findUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
	          //set tout les attributs
	         findUser.setEmail(user.getEmail());
	         findUser.setLogin(user.getLogin());
	         findUser.setPassowrd(user.getPassowrd());
	         final User lastUser=userRepository.save(findUser);
	         return ResponseEntity.ok(lastUser); 
	    }
}
