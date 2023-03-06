package com.stlh.paitentbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Entity Class

@Data
@Entity
@Table(name="patientsdb")
public class Patient {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	@Column(name="Firstname",nullable=false)
	private String firstname;
	
	@Column(name="Lastname")
	private String lastname;
	
	@Column(name="Age")
	private Integer age;
	
	@Column(name="Gender")
	private String gender;

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="Phnnumber")
	private String phnnumber;
	
	@Column(name="Password")
	private String password;
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnnumber() {
		return phnnumber;
	}

	public void setPhnnumber(String phnnumber) {
		this.phnnumber = phnnumber;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}