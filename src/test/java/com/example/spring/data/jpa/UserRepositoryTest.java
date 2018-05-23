package com.example.spring.data.jpa;

import com.example.spring.data.jpa.aspect.SimpleAspect;
import com.example.spring.data.jpa.model.User;
import com.example.spring.data.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
//@EnableAspectJAutoProxy
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void testSave() throws Exception {
		List<User> users = new ArrayList<>(100);
		for (int i = 0; i < 35; i++) {
			User user = new User();
			user.setName("user-" + i);
			users.add(user);
		}

		repository.saveAll(users);

		int pageSize = 10;
		int pageIndex = 0;

		Page<User> page = null;
		do {
//			System.out.println("===============================");
			Pageable pageable = page == null ? new PageRequest(pageIndex, pageSize) : page.nextPageable();
			System.out.println(pageable);
//			System.out.println("page=" + pageable.getPageNumber()
//					+ "; size=" + pageable.getPageSize()
//					+ "; offset=" + pageable.getOffset());
//			System.out.println("Paging params: " + pageable);
			page = repository.findAll(pageable);
//			System.out.println(page.getNumber() + ": " + page.getContent());
//			pageable = page.nextPageable();
		} while (page.hasNext() && page.hasContent());

		System.out.println("Total elements: " + page.getTotalElements());
	}
}
