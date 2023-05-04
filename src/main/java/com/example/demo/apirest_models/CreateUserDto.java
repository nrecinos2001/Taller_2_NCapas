package com.example.demo.apirest_models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDto {
	private String password;
	private String name;
	private String lastname;
	private String username;
	private String email;
	private Long hiredDate;
}
