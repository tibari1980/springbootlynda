package com.bnp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User implements Serializable {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="LOGIN")
	private String login;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String passowrd;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String login, String email, String passowrd) {
		super();
		this.login = login;
		this.email = email;
		this.passowrd = passowrd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	
	
	  
	
}
