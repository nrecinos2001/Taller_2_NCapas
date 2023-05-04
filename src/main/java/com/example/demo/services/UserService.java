package com.example.demo.services;

import java.util.List;

import com.example.demo.apirest_models.AuthDto;
import com.example.demo.apirest_models.CreateUserDto;
import com.example.demo.apirest_models.LoggedUserDto;
import com.example.demo.apirest_models.UserEntity;
import com.example.demo.apirest_models.UsersDto;

public interface UserService {
	LoggedUserDto signIn(AuthDto authDto);
	List<UsersDto> getAll(); // TODO Update Return Type
	UsersDto getOneById(String code); // TODO Update return type
	String create(CreateUserDto createUserDto); // TODO Update return type
	String changePassword(String info); // TODO update return type
	String toggleActive(String code); // TODO update return type
	void save(String info); // TODO Update return type
}
