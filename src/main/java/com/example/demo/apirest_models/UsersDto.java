package com.example.demo.apirest_models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDto {
	String name;
	String lastname;
	String username;
	String role;
	String email;
	Boolean isActive;
}
