package com.example.demo.services;

import java.util.List;

import com.example.demo.apirest_models.AuthDto;
import com.example.demo.apirest_models.ChangePasswordDto;
import com.example.demo.apirest_models.CreateUserDto;
import com.example.demo.apirest_models.LoggedUserDto;
import com.example.demo.apirest_models.UserEntity;
import com.example.demo.apirest_models.UsersDto;

public interface UserService {
	LoggedUserDto signIn(AuthDto authDto);
	List<UsersDto> getAll();
	UsersDto getOneById(String code);
	String create(CreateUserDto createUserDto);
	String changePassword(String identifier, ChangePasswordDto changePasswordDto); // TODO update return type
	String toggleActive(String code);
}
