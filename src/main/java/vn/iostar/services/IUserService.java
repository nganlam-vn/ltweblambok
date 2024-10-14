package vn.iostar.services;

import java.sql.Date;

import vn.iostar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUsername(String username);
	
	boolean register(String fullName, String username, String password, String email, 
			String phoneNumber);
	
	void insert(UserModel user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);

}
