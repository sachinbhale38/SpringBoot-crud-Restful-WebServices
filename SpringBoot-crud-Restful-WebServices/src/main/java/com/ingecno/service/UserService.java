package com.ingecno.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingecno.entity.UserDetails;
import com.ingecno.exception.ResourceNotFoundException;
import com.ingecno.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDetails> getAllUsers() {
		List<UserDetails> users=userRepository.findAll();
		System.out.println("Getting Data From Db : "+users);
		return users;
	}

	public UserDetails getUserById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With id" + userId));
	}

	public UserDetails createUser(@Valid UserDetails user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public UserDetails updateUser(long userId,UserDetails user) {
		UserDetails existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found With id :" + userId));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setDept(user.getDept());
		existingUser.setPhno(user.getPhno());
		existingUser.setStatus(user.getStatus());
		existingUser.setCreatedby(user.getCreatedby());
		existingUser.setCreatedtm(user.getCreatedtm());
		existingUser.setUpdatedby(user.getUpdatedby());
		existingUser.setUpdateddtm(user.getUpdateddtm());
		existingUser.setCountry(user.getCountry());
		
		return userRepository.save(existingUser);
	}

	public void deleteUser(long userId) {
	
		userRepository.deleteById(userId);;
	}

	public UserDetails suspendUser(long userId) {
		UserDetails suspendUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With id :" + userId));
		suspendUser.setStatus("Inactive");
		return userRepository.save(suspendUser);

		
	}

	public UserDetails activateUser(long userId) {
		UserDetails activateUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With id :" + userId));
		activateUser.setStatus("active");
		return userRepository.save(activateUser);
	}

}
