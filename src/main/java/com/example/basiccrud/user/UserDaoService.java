package com.example.basiccrud.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserDaoService {
	
	private static int userCount = 1000;
	private static List<User> userList = new ArrayList<>();
	static {
		userList.add(new User(++userCount,"pradeep",LocalDate.now().minusYears(22),"7982792929"));
		userList.add(new User(++userCount,"suhass",LocalDate.now().minusYears(24),"9792792929"));
		userList.add(new User(++userCount,"ravi",LocalDate.now().minusYears(29),"9782792929"));
	}
	
	public List<User> retriveUsers() {
		return userList;
	}
	
	public User getUserById(int id) {
		return userList.stream().filter(user->user.getId()==id).findFirst().get();
	}
	
	public User save(User user) {
		user.setId(++userCount);
		userList.add(user);
		return user;
	}

	public User updateUser(int id, User updatedUser) {
	    return userList.stream()
	            .filter(user -> user.getId() == id)
	            .findFirst()
	            .map(user -> {
	                user.setName(updatedUser.getName());
	                user.setDob(updatedUser.getDob());
	                user.setMobileNumber(updatedUser.getMobileNumber());
	                return user;
	            })
	            .orElse(null);
	}
	
	public boolean deleteUser(int id) {
		return userList.removeIf(user->user.getId()==id);
	}
}
