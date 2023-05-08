package com.example.demo.apirest_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthDto {
	
	private String identifier;
	private String password;
}


