package com.example.basiccrud.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class UserDaoService {
	
//	private static int userCount = 1000;
//	private static List<User> userList = new ArrayList<>();
//	static {
//		userList.add(new User(++userCount,"pradeep",LocalDate.now().minusYears(22),"7982792929"));
//		userList.add(new User(++userCount,"suhass",LocalDate.now().minusYears(24),"9792792929"));
//		userList.add(new User(++userCount,"ravi",LocalDate.now().minusYears(29),"9782792929"));
//	}
	
	private UserRepository userRepository;
	
	public UserDaoService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> retriveUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

	public User updateUser(int id, User updatedUser) {
		userRepository.deleteById(id);
		updatedUser.setId(id);
		return userRepository.save(updatedUser);
	}
	
	public boolean deleteUser(int id) {
		if(getUserById(id)!=null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
