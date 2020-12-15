package com.ingecno.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingecno.entity.Register;
import com.ingecno.exception.ResourceNotFoundException;
import com.ingecno.repository.RegisterRepository;

@Service
public class LoginService {
	
	@Autowired
	private RegisterRepository registerRepository;

	public List<Register> getAllUsers() {
		// TODO Auto-generated method stub
		return registerRepository.findAll();
	}

	public Register getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return registerRepository.getUserByEmail(email);
	}

	public Register findById(long userId) {
		// TODO Auto-generated method stub
		return registerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With id" + userId));
	}

	public Register getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return registerRepository.getUserByUserName(name);
	}

	public Register checkLogin(@Valid String email, String password) {
		// TODO Auto-generated method stub
		return registerRepository.checkLogin(email, password);
	}

}
