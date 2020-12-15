package com.ingecno.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Size(min = 2, message = "First Name should have atleast 2 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 2, message = "Last Name should have atleast 2 characters")
	@Column(name = "lastst_name")
	private String lastName;

	@NotBlank
	@Email
	@Column(name = "email")
	private String email;

	private String phno;
	private String status;
	private String createdby;
	private Date createdtm;
	private String dept;
	private String updatedby;
	private Date updateddtm;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	private Country country;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(long id,
			@NotNull @Size(min = 2, message = "First Name should have atleast 2 characters") String firstName,
			@NotNull @Size(min = 2, message = "Last Name should have atleast 2 characters") String lastName,
			@NotBlank @Email String email, String phno, String status, String createdby, Date createdtm,
			String dept, String updatedby, Date updateddtm, Country country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phno = phno;
		this.status = status;
		this.createdby = createdby;
		this.createdtm = createdtm;
		this.dept = dept;
		this.updatedby = updatedby;
		this.updateddtm = updateddtm;
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getCreatedtm() {
		return createdtm;
	}

	public void setCreatedtm(Date createdtm) {
		this.createdtm = createdtm;
	}

	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phno=" + phno + ", status=" + status + ", createdby=" + createdby + ", createdtm=" + createdtm
				+ ", dept=" + dept + ", updatedby=" + updatedby + ", updateddtm=" + updateddtm + ", country=" + country
				+ "]";
	}

}
