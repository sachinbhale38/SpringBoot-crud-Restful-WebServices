package com.ingecno.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "registration")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uId;
	@NotNull
	@Size(min = 2, message = "First Name should have atleast 2 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 2, message = "Last Name should have atleast 2 characters")
	@Column(name = "lastst_name")
	private String lastName;

	private String username;
	private String email;
	private String password;
	private String mobile;
	private String address;
	
	
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int uId,
			@NotNull @Size(min = 2, message = "First Name should have atleast 2 characters") String firstName,
			@NotNull @Size(min = 2, message = "Last Name should have atleast 2 characters") String lastName,
			String username, String email, String password, String mobile, String address) {
		super();
		this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public long getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Register [uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
