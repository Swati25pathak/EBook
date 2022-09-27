package com.Ebook.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "user_table")
public class User {
@Id
@GeneratedValue
private long reg_no;
@NotNull(message = "name should not be null")
@Size(min=4, message="Name should be 4-20 characters")
private String user_name;
@Email(message = "you should follow the emailvalidation")
private String email;
@NotNull(message = "name should not be null")
@Column(name = "password")
private String password;
public long getReg_no() {
	return reg_no;
}
public void setReg_no(long reg_no) {
	this.reg_no = reg_no;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
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
@Override
public String toString() {
	return "User [reg_no=" + reg_no + ", user_name=" + user_name + ", email=" + email + ", password=" + password + "]";
}
}
