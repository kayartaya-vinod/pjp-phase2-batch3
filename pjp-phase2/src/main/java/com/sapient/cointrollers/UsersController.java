package com.sapient.cointrollers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.UsersDao;
import com.sapient.entity.User;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {

	UsersDao dao = new UsersDao();

	@GetMapping
	public List<User> allUsers() {

		return dao.getAll();
	}

	@GetMapping("/{id}")
	public User oneUser(@PathVariable Integer id) {
		return dao.getById(id);
	}

}
