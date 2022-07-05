package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="db_usermanagement")
public class UserManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name="name",length = 200,nullable = false)
	private String name;
	@Column(name="email",length = 200,precision = 2)
	private String email;
	@Column(name="age",length = 99,nullable = false)
	private int age;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserManagement [Id=" + Id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	
	

}
