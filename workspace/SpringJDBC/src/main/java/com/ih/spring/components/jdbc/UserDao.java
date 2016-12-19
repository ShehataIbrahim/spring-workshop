package com.ih.spring.components.jdbc;

import java.util.Collection;

public interface UserDao {
	public User findUser(String name);
	public Collection<User> findUsers();
}
