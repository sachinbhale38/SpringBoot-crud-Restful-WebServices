package com.ingecno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingecno.entity.Country;
import com.ingecno.entity.UserDetails;
import com.ingecno.service.CountryService;
import com.ingecno.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CountryService countryService;

	
	// get all users
	@GetMapping
	public List<UserDetails> getAllUsers() {
		List<UserDetails> users=userService.getAllUsers();
		System.out.println("Getting Data From Db : "+users);
		return users;

	}

	// get user by id
	@GetMapping("/{id}")
	public UserDetails getUserById(@PathVariable(value = "id") long userId) {
		System.err.println("getting user with id :" +userId);
		return userService.getUserById(userId);

	}

	// create User
	@PostMapping
	public UserDetails createUser(@Valid @RequestBody UserDetails user) {
		System.err.println("creating user........");
		return userService.createUser(user);

	}

	// update user--put mapping
	@PutMapping("/{id}")
	public UserDetails updateUser(@Valid @RequestBody UserDetails user, @PathVariable(value = "id") long userId) {

		return userService.updateUser(userId, user);
	}

	// delete user by id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long userId) {
		userService.deleteUser(userId);

	}

	@RequestMapping("/delete/{id}")
	public void deletebyCountry(@PathVariable("id") long cid) {
		countryService.deletebyCountry(cid);
	}

	// 14 get countries
	@RequestMapping("/country/getall")
	public List<Country> fetchAllCountry() {
		return countryService.fetchAllCountry();
	}

	// suspend user
	@GetMapping("suspend/{id}")
	public UserDetails suspendUser(@PathVariable(value = "id") long userId) {
		return userService.suspendUser(userId);

	}

	// activate user
	@GetMapping("activate/{id}")
	public UserDetails activateUser(@PathVariable(value = "id") long userId) {
		return userService.activateUser(userId);

	}
}
