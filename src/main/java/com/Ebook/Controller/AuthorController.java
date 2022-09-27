package com.Ebook.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ebook.Entity.Author;
import com.Ebook.Exception.ResourceNotFoundException;
import com.Ebook.Service.AutherService;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class AuthorController {

	@Autowired
	private AutherService authorservice;

	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

	
//	@CrossOrigin(origins  = "http://localhost:4200",allowCredentials = true)
	@PostMapping("/addauthor")
//	@CrossOrigin(origins = "*")
	@ResponseBody
	public ResponseEntity<Author> addAuthorDetails(@RequestBody Author author) {
		logger.info("adding the author details");
		System.out.println(author.getUsertype());
		Author post = authorservice.AddDetails(author);
		return new ResponseEntity<Author>(post, HttpStatus.OK);
	}

	@GetMapping("/getauthordetails")
	@ResponseBody
	public ResponseEntity<List<Author>> getAuthorDetails() {
		List<Author> store = authorservice.getDetails();
		return new ResponseEntity<List<Author>>(store, HttpStatus.OK);

	}
	
	@GetMapping("/getbyid/{regnumber}")
	public ResponseEntity<Author> getAuthorDetailsById(@PathVariable("regnumber") Long Registrationnumber) {
		logger.info("Get user details by id");
		Author author= authorservice.findUserById(Registrationnumber);
		return new ResponseEntity<Author>(author,HttpStatus.OK);	
	}
	
	

	@ResponseBody
	@DeleteMapping("/deleteauthor/{regnumber}")
	public ResponseEntity<String> deleteauthor(@PathVariable("regnumber") Long Registrationnumber)
			throws ResourceNotFoundException {
		String check = authorservice.deleteRegister(Registrationnumber);
		return new ResponseEntity<String>(check, HttpStatus.OK);

	}

	@ResponseBody
	@PutMapping("/updateauthor/{id}")
	public ResponseEntity<Author> updateauthorDetails(@RequestBody Author author, @PathVariable("id") Long authorid)
			throws ResourceNotFoundException {
		Author update = authorservice.updateAuthorDetails(author, authorid);
		return new ResponseEntity<Author>(update, HttpStatus.OK);

//		
//		@GetMapping("/user/{id}")
//public ResponseEntity<Author> getUserById(@PathVariable(value = "id") Integer userid) throws ResourceNotFoundException {
//			logger.info("Get user details by id");
//			User user= userService.findUserById(userid);
//			return  ResponseEntity.ok(user);
//		}
	
	
	
		
		
	}
}