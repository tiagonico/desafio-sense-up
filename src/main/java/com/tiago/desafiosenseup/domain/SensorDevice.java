package com.tiago.desafiosenseup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SensorDevice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String key;
	private String label;
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@OneToMany(mappedBy = "sensorDevice")
	@Column(name="streams")
	private List<DataStream> dataStreams =  new ArrayList<>();
	
	//Constructors
	
	public SensorDevice() {
		
	}
	
	public SensorDevice(Integer id, String key, String label, String description, User user,
			List<DataStream> dataStreams) {
		this.id = id;
		this.key = key;
		this.label = label;
		this.description = description;
		this.user = user;
		this.dataStreams = dataStreams;
	}

	//Getters and Setters
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<DataStream> getStreams() {
		return dataStreams;
	}
	public void setDataStreams(List<DataStream> dataStreams) {
		this.dataStreams = dataStreams;
	}
	
}
