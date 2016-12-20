package com.ih.spring.components.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECURITY_USER", schema = "SPRINGJDBC")
public class SecurityUser implements java.io.Serializable {

	private String name;
	private String password;
	private String enabled;

	public SecurityUser() {
	}

	public SecurityUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public SecurityUser(String name, String password, String enabled) {
		this.name = name;
		this.password = password;
		this.enabled = enabled;
	}

	@Id

	@Column(name = "NAME", unique = true, nullable = false, length = 35)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ENABLED", length = 20)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "SecurityUser [name=" + name + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
}
