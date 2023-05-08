package com.example.demo.apirest_models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {
		
	@NotEmpty(message = "Password vacia!")
	@Size(min =8, max = 14, message = "Minimo 8, maximo 14")
	private String password;
	
	@NotEmpty(message = "Name vacio!")
	private String name;
	
	@NotEmpty(message = "Lastname vacio!")
	private String lastname;
	
	@NotEmpty(message = "Username vacio!")
	private String username;
	
	@NotEmpty(message = "Email vacio!")
	@Email(message = "Formato de dueño incorrecto")
	private String email;
	
	@NotEmpty(message = "Hired date vacio!")
	private Long hiredDate;
}
