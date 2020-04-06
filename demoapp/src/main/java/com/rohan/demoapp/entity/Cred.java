package com.rohan.demoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cred")
public class Cred {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "username is mandatory")
	@Column(name = "username")
	private String username;

	@NotBlank(message = "Password is mandatory")
	@Column(name = "password")
	private String password;

	public Cred(long id, @NotBlank(message = "username is mandatory") String username,
			@NotBlank(message = "Password is mandatory") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cred() {
	}

}
