package com.example.spring.data.jpa;

import com.example.spring.data.jpa.model.User;
import com.example.spring.data.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void testSave() throws Exception {
		User user = new User();
		user.setName("John Smith");

		repository.save(user);
	}
}
