package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apirest_models.UserDto;
import com.example.demo.apirest_models.UserEntity;
import com.example.demo.apirest_models.UsersDto;
import com.example.demo.services.UserService;
import com.example.demo.services.implementations.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
		public ResponseEntity<UsersDto> getAll() {
		List<UsersDto> users = userService.getAll();
		return new ResponseEntity(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UsersDto> getOneById(@RequestParam(value = "code") String code){
		UsersDto user = userService.getOneById(code);
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<UsersDto> create(@Valid @RequestBody UsersDto user){
		UsersDto userCreated = userService.create(user);
		return new ResponseEntity(userm HttpStatus.CREATED)
	}
	
	@RequestMapping(value = "/user/change-password", method = RequestMethod.PATCH)
	public ResponseEntity<UsersDto> changePassword()
	
	
	
	@RequestMapping(value = "/user/toogle-active", method = ResquestMethod.PATCH)
}
	
	
	
	*/

}
