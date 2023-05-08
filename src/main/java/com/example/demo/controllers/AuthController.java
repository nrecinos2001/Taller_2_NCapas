package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.apirest_models.AuthDto;
import com.example.demo.apirest_models.LoggedUserDto;
import com.example.demo.services.UserService;

@Controller
//@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

@Autowired
private UserService userService;

public AuthController(UserService userService) {
	this.userService = userService;
}


@PostMapping("/auth/signin")
public LoggedUserDto signIn(@RequestBody AuthDto user) {
	return userService.signIn(user);
}

/*
@PostMapping("/auth/signin")
public LoggedUserDto signIn(@RequestBody AuthDto user) {
LoggedUserDto signin= userService.signIn(user);
if(signin == null) {
	return new ResponseEntity(HttpStatus.NOT_FOUND);
}
return new ResponseEntity(signin, HttpStatus.NOT_FOUND);
}*/
}
