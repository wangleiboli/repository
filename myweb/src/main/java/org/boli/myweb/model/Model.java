package org.boli.myweb.model;

import java.util.List;

import org.boli.myweb.entity.User;

public class Model {

	User user;

	List<User> users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
