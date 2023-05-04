package com.example.demo.apirest_models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDto {
	private String identifier;
	private String password;
	
}


