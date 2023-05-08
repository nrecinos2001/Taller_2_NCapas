package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apirest_models.CreateUserDto;
import com.example.demo.apirest_models.UserDto;
import com.example.demo.apirest_models.UserEntity;
import com.example.demo.apirest_models.UsersDto;
import com.example.demo.services.UserService;
import com.example.demo.services.implementations.UserServiceImpl;

@RestController
//@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	 
	@PostMapping("/user/")
	    public String create(@RequestBody CreateUserDto user) {
	        return userService.create(user);
	    }
	    
	@GetMapping("/user/all")
		public ResponseEntity<UsersDto> getAll() {
		List<UsersDto> users = userService.getAll();
		return new ResponseEntity(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/")
	public ResponseEntity<UsersDto> getOneById(@RequestParam(value = "code") String code){
		UsersDto user = userService.getOneById(code);
		if(user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity(user, HttpStatus.OK);
		
	}
	
	
	@PatchMapping("/user/toogle-active/")
	public ResponseEntity<String> toogleActive(@RequestParam(value = "code") String code){
		String user = userService.toggleActive(code);
		
		if(user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK); 
	}
}

