package com.example.demo.apirest_models;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoggedUserDto {
	
	@NotEmpty(message = "Campo vacio")
	String username;
	
	@NotEmpty(message = "Campo vacio")
	String role;
	
	@NotEmpty(message = "Campo vacio")
	String email;
}
