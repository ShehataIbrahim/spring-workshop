package com.ih.spring.components.jdbc;

public class User {
	private String name;
	private String password;
	private boolean enabled;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", enabled=" + enabled + "]";
	}

	public User(String name, String password, boolean enabled) {
		super();
		this.name = name;
		this.password = password;
		this.enabled = enabled;
	}

	public User() {
		super();
	}

}
