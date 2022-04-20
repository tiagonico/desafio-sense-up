package com.tiago.desafiosenseup.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SensorData implements Serializable,Comparable<SensorData>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long timestamp;
	private Double value;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "measurement_unit_id")
	private MeasurementUnit measurementUnit;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "data_stream_id")
	private DataStream dataStream;
	
	//Constructors
	
	public SensorData() {
		
	}
	
	public SensorData(Integer id, Long timestamp, Double value, MeasurementUnit measurementUnit,
			DataStream dataStream) {
		this.id = id;
		this.timestamp = timestamp;
		this.value = value;
		this.measurementUnit = measurementUnit;
		this.dataStream = dataStream;
	}

	//Getters and Setters
	
	@JsonIgnore
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public DataStream getDataStream() {
		return dataStream;
	}
	public void setDataStream(DataStream dataStream) {
		this.dataStream = dataStream;
	}	
	

	@Override
	public int compareTo(SensorData o) {
		if (getTimestamp() == null || o.getTimestamp() == null) {
		      return 0;
		    }
		return getTimestamp().compareTo(o.getTimestamp());
	}

}
