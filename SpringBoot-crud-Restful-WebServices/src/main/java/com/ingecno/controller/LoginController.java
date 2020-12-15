package com.ingecno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingecno.entity.Register;
import com.ingecno.entity.UserDetails;
import com.ingecno.exception.ResourceNotFoundException;
import com.ingecno.repository.RegisterRepository;
import com.ingecno.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {

//	@Autowired
//	private RegisterRepository registerRepository;
//	
	@Autowired
	private LoginService loginService;

	@GetMapping
	public List<Register> getAllUsers() {
	
		return loginService.getAllUsers();

	}

	// get user by id
	@GetMapping("/{id}")
	public Register getUserById(@PathVariable(value = "id") long userId) {
		return loginService.findById(userId);

	}

	// get user by username
	@GetMapping("/getbyname/{name}")
	public Register getUserByUserName(@PathVariable String name) {

		return loginService.getUserByUserName(name);

	}

	// get user by username
	@GetMapping("/getbyname/{email}")
	public Register getUserByEmail(@PathVariable String email) {

		return loginService.getUserByEmail(email);

	}

	// create User
	@GetMapping("/{email}/{password}")
	public HashMap createUser(@Valid @PathVariable String email, @PathVariable String password) {

		HashMap m = new HashMap();

		System.err.println(email);
		System.err.println(password);

		Register r = loginService.checkLogin(email, password);
//			System.err.println(r.getEmail());
//			System.err.println(r.getPassword());
//			System.err.println(r);
		System.err.println(r);

		if (r == null) {
			m.put("msg", "invalid user");
		}

		else {
			m.put("msg", "valid user");
			m.put("user", r);
		}

		return m;
	}
}
