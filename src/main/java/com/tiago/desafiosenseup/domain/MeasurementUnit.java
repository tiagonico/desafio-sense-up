package com.tiago.desafiosenseup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MeasurementUnit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String symbol;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "measurementUnit")
	private List<DataStream> dataStreams =  new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "measurementUnit")
	private List<SensorData> sensorDatas =  new ArrayList<>();
	
	//Constructors
	
	public MeasurementUnit() {
		
	}
		
	public MeasurementUnit(Integer id, String symbol, String description) {
		this.id = id;
		this.symbol = symbol;
		this.description = description;
	}
	
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DataStream> getDataStreams() {
		return dataStreams;
	}
	public void setDataStreams(List<DataStream> dataStreams) {
		this.dataStreams = dataStreams;
	}
	public List<SensorData> getSensorDatas() {
		return sensorDatas;
	}
	public void setSensorDatas(List<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}	

}
