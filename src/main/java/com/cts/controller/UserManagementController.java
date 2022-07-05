package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.UserManagement;
import com.cts.repository.UserManagementRepository;

import java.util.Optional;
@RestController
public class UserManagementController {
	
	@Autowired
	private UserManagementRepository userrepository;
	
	@GetMapping("/users")
	public List<UserManagement> getAllUsers()
	{
		return userrepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public UserManagement getUserById(@PathVariable Integer id)
	{
		Optional<UserManagement> usermanagement= userrepository.findById(id);
		if(usermanagement.isPresent())
			return usermanagement.get();
		else 
			return null;
		
	}
	
	@PostMapping("/users")
	public UserManagement createUser(@RequestBody UserManagement usermanagement)
	{
		return userrepository.save(usermanagement);
	}
	
	@PutMapping("/users/{id}")
	public UserManagement updateUser(@RequestBody UserManagement usermanagement,@PathVariable Integer id)
	{
		Optional<UserManagement> usermanagementtemp= userrepository.findById(id);
		if(usermanagementtemp.isPresent())
		{
			UserManagement userToUpdate = usermanagementtemp.get();
			userToUpdate.setName(usermanagement.getName());
			userToUpdate.setEmail(usermanagement.getEmail());
			userToUpdate.setAge(usermanagement.getAge());
			
			userToUpdate=userrepository.save(userToUpdate);
			return userToUpdate;
		}
		else 
			return null;
	}
	
	@DeleteMapping("/users/{id}")
	public Boolean deleteUserById(@PathVariable Integer id)
	{
		Optional<UserManagement> usermanagemen= userrepository.findById(id);
		if(usermanagemen.isPresent()) {
			userrepository.deleteById(id);
			return true;
		}
		else 
			return false;

	}
	

}
