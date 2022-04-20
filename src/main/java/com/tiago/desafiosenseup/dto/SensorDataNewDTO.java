package com.tiago.desafiosenseup.dto;

import java.io.Serializable;

import com.tiago.desafiosenseup.domain.SensorData;

public class SensorDataNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Long timestamp;
	private Double value;
	private Integer unitId;
	
	public SensorDataNewDTO() {
		
	}
	
	public SensorDataNewDTO(SensorData obj) {
		id = obj.getId();
		timestamp = obj.getTimestamp();
		value = obj.getValue();
		unitId = obj.getMeasurementUnit().getId();
	}

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

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
		
}
