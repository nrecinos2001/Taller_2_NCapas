package apirest_models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserEntity {

	@Data
	@AllArgsConstructor
	public class User {
		private String code;
		private String password;
		private String name;
		private String lastname;
		private String role;
		private Boolean isActive;
		private Date hired;
	}
	
}
