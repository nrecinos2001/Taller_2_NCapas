package com.example.demo.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.apirest_models.UserEntity;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static List<UserEntity> users = new ArrayList<UserEntity>();
	
	static {
        users.add(new UserEntity("AH000011", "pass", "Arturo", "Hernandez", "user", true, new Date()));
        users.add(new UserEntity("AO000022", "pass", "Alejandro", "Ortega", "user", false, new Date()));
        users.add(new UserEntity("JP000033", "pass", "Josue", "Perez", "user", true, new Date()));
        users.add(new UserEntity("NR000044", "pass", "Nestor", "Recinos", "admin", true, new Date()));
    }
	
	@Override
	public String signIn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOneById(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toggleActive(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String info) {
		// TODO Auto-generated method stub
		
	}

}
