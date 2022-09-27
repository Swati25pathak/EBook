package com.Ebook.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "author")
@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long registrationNumber;

	@Enumerated(EnumType.STRING)
	private UserType usertype;

	@NotNull(message = "name should not be null")
	@Column(name = "username")
	private String userName;

	@NotNull(message = "name should not be null")
	@Column(name = "password")
	private String password;

	@NotNull(message = "name should not be null")
	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "email")
	@Email(message = "you should follow the emailvalidation")
	private String email;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Long registrationNumber, UserType usertype,
			@NotNull(message = "name should not be null") String userName,
			@NotNull(message = "name should not be null") String password,
			@NotNull(message = "name should not be null") String mobileNumber,
			@Email(message = "you should follow the emailvalidation") String email) {
		super();
		this.registrationNumber = registrationNumber;
		this.usertype = usertype;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public Long getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override	public String toString() {
		return "Author [registrationNumber=" + registrationNumber + ", usertype=" + usertype + ", userName=" + userName
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
}