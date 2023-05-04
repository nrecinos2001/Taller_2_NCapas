package com.example.demo.apirest_models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDto {
	String name;
	String lastname;
	String role;
	String email;
	Date hiredDate;
}
