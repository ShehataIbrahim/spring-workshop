package com.ih.spring.components.orm;

import java.util.Collection;

public interface SecurityUserDao {
	public SecurityUser findUser(String name);

	public void update(SecurityUser user);

	public void deleteUser(String name);
	public Collection<SecurityUser> findUsers();
}
