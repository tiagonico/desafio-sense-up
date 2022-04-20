package com.tiago.desafiosenseup.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.tiago.desafiosenseup.domain.SensorDevice;

public class SensorDeviceGetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String key;	
	private String label;	
	private String description;
	private List<DataStreamSensorDeviceDTO> streams;
	
	public SensorDeviceGetDTO() {
		
	}
	
	public SensorDeviceGetDTO(SensorDevice obj) {
		id = obj.getId();
		label = obj.getLabel();
		key = obj.getKey();
		description = obj.getDescription();
		streams = obj.getStreams().stream().map(objto -> new DataStreamSensorDeviceDTO(objto)).collect(Collectors.toList());
	}

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

	public List<DataStreamSensorDeviceDTO> getStreams() {
		return streams;
	}

	public void setStreams(List<DataStreamSensorDeviceDTO> streams) {
		this.streams = streams;
	}

	
	

}
