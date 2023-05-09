package com.example.demo.apirest_models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordDto {
	private String oldPassword;
	private String newPassword;
}
