package com.tiago.desafiosenseup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	
	
	@OneToMany(mappedBy = "user")
	private List<SensorDevice> sensorDevices =  new ArrayList<>();

	//Constructors
	
	public User() {
		
	}
		
	public User(Integer id, String username, String email, List<SensorDevice> sensorDevices) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.sensorDevices = sensorDevices;
	}
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<SensorDevice> getSensorDevices() {
		return sensorDevices;
	}

	public void setSensorDevices(List<SensorDevice> sensorDevices) {
		this.sensorDevices = sensorDevices;
	}	
		
}
