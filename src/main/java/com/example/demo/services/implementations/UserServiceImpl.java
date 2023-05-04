package com.example.demo.services.implementations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.apirest_models.AuthDto;
import com.example.demo.apirest_models.CreateUserDto;
import com.example.demo.apirest_models.LoggedUserDto;
import com.example.demo.apirest_models.UserEntity;
import com.example.demo.apirest_models.UsersDto;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static List<UserEntity> users = new ArrayList<UserEntity>();
	
	static {
        users.add(new UserEntity("AH000011", "pass-encrypted", "Arturo", "Hernandez", "user","ahernandez", "ahernandez@contoso.com", true, new Date(25052023)));
        users.add(new UserEntity("AO000022", "pass-encrypted", "Alejandro", "Ortega", "user","aortega","aortega@contoso.com", false, new Date(18012022)));
        users.add(new UserEntity("JP000033", "pass-encrypted", "Josue", "Perez", "user","jperez","jperez@contoso.com", true, new Date(12122001)));
        users.add(new UserEntity("NR000044", "pass-encrypted", "Nestor", "Recinos", "admin","nrecinos","nrecinos@contoso.com", true, new Date(18032022)));
    }
	
	@Override
	public LoggedUserDto signIn(AuthDto authDto) {
		for (UserEntity user: users) {
			if(user.getUsername().equals(authDto.getIdentifier()) || user.getEmail().equals(authDto.getIdentifier())) {
				if (user.getPassword().equals(authDto.getPassword()+"-encrypted")) {
					LocalDateTime actualDate = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					Long formattedDate = Long.parseLong(actualDate.format(formatter));
					
					if (user.getHiredDate().after(new Date(formattedDate))) {
						return null;
					}
					if (!user.getIsActive()) {
						return null;
					}
					LoggedUserDto loggedUser = new LoggedUserDto(user.getUsername(), user.getRole(), user.getEmail());
					return loggedUser;
				}
			}
		}
		return null;
	}

	@Override
	public List<UsersDto> getAll() {
		List<UsersDto> usersList = new ArrayList<>();
		for(UserEntity user: users) {
			usersList.add(new UsersDto(user.getName(), user.getLastname(), user.getRole(), user.getEmail(), user.getHiredDate()));
		}
		return usersList;
	}

	@Override
	public UsersDto getOneById(String code) {
		UserEntity user = users.stream()
		.filter(b -> b.getCode().equals(code))
		.findAny()
		.orElse(null);
		
		if(user == null) {
			return null;
		}

		UsersDto mappedUser = new UsersDto(user.getName(), user.getLastname(), user.getRole(), user.getEmail(), user.getHiredDate());
		return mappedUser;
	}

	@Override
	public String create(CreateUserDto createUserDto) {
		int randomNumber = (int)(Math.random()*10+1);
		String code = "" + createUserDto.getName().charAt(0) + createUserDto.getLastname().charAt(0) + randomNumber;
		String encryptedPassword = createUserDto.getPassword().concat("-encrypted");
		users.add(new UserEntity(code, encryptedPassword, createUserDto.getName(), createUserDto.getLastname(), "user", createUserDto.getUsername(), createUserDto.getEmail(), false, new Date()));
		return "The user was created successfully";
	}

	@Override
	public String changePassword(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toggleActive(String code) {
		UserEntity user = users.stream()
				.filter(b -> b.getCode().equals(code))
				.findAny()
				.orElse(null);
		if (user == null) {
			return null;			
		}
		int index = users.indexOf(user);
		if (user.getIsActive()) {
			user.setIsActive(false);
			users.set(index, user);
			return "User deactivated successfully";
		}
		user.setIsActive(true);
		users.set(index, user);
		return "User activated successfully";
	}

	@Override
	public void save(String info) {
		// TODO Auto-generated method stub
		
	}

}
