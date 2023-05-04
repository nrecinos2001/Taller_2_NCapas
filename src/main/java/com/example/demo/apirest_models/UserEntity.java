package com.example.demo.apirest_models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserEntity {
		private String code;
		private String password;
		private String name;
		private String lastname;
		private String role;
		private Boolean isActive;
		private Date hired;
}
