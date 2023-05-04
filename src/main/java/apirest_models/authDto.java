package apirest_models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class authDto {
	private String identifier;
	private String password;
}