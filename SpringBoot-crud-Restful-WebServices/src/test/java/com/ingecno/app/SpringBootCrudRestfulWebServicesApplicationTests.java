package com.ingecno.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ingecno.entity.Country;
import com.ingecno.entity.UserDetails;
import com.ingecno.repository.UserRepository;
import com.ingecno.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootCrudRestfulWebServicesApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getAllUsers() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new UserDetails(121, "sachin", "bhale", "sachinbhale@gmail.com", "8390564941", "active", "admin",
						new Date(), "marketing", "jbk", new Date(), new Country(4, "india")),
						new UserDetails(121, "mahesh", "tiwari", "mahesh@gmail.com", "9767144164", "active", "admin",
								new Date(), "licking", "baba", new Date(), new Country(8, "USA")))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllUsers().size());

	}

	@Test
	public void saveUserTest() {
		UserDetails u = new UserDetails(121, "mahesh", "tiwari", "mahesh@gmail.com", "9767144164", "active", "admin",
				new Date(), "licking", "baba", new Date(), new Country(8, "USA"));
		when(userRepository.save(u)).thenReturn(u);
		assertEquals(u, userService.createUser(u));
	}

	@Test
	public void deleteUserTest() {
		UserDetails u = new UserDetails(121, "mahesh", "tiwari", "mahesh@gmail.com", "9767144164", "active", "admin",
				new Date(), "licking", "baba", new Date(), new Country(8, "USA"));
		long id=u.getId();
		userService.deleteUser(id);
		verify(userRepository, times(1)).deleteById(id);

	}

}
