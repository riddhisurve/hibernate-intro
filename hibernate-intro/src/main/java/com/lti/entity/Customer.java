package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUST")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	private int id;

	@Column(name = "CUST_NAME")
	private String name;

	@Column(name = "CUST_EMAIL")
	private String email;

	@Column(name = "CUST_CITY")
	private String city;

	@Column(name = "CUST_PASS")
	private String password;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", password="
				+ password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
