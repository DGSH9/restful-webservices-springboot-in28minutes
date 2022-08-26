package com.dgsh.rest.web.services.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public static int userCountId = 3;

	public static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1, "Durgesh", new Date()));
		users.add(new User(2, "Neeraj", new Date()));
		users.add(new User(3, "Prince", new Date()));
	}

	// Get All Users
	public List<User> findAll() {
		return users;
	}

	// Save User
	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCountId);
		}
		users.add(user);
		return user;
	}

	// Get One User
	public User findUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	// Delete One User
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
