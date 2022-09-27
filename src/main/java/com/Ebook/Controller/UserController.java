package com.Ebook.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ebook.Entity.User;
import com.Ebook.Service.UserServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/addUser")
	public User addUser(@Valid @RequestBody User user) {
		User u = userService.addUser(user);
		return userService.addUser(user);
	}
}