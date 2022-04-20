package com.tiago.desafiosenseup.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.domain.SensorData;

@JsonPropertyOrder({"id","key","label","unitId","deviceId","measurementCount","measurements"})
public class DataStreamGetDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String key;
	
	private String label;
	
	private Integer unitId;
	
	private Integer deviceId;
	
	private List<SensorData> sensorDatas =  new ArrayList<>();
	
	public DataStreamGetDTO() {
		
	}
	
	public DataStreamGetDTO(DataStream obj) {
		id = obj.getId();
		key = obj.getKey();
		label = obj.getLabel();
		unitId = obj.getUnitId();
		deviceId = obj.getDeviceId();
		sensorDatas = obj.getMeasurements();
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

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	
	public Integer getMeasurementCount() {
		
		if(this.sensorDatas == null) {
			return 0;
		}
		return this.sensorDatas.size();
	}

	public List<SensorData> getMeasurements() {
		
		return sensorDatas;
	}

	public void setSensorDatas(List<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}
	

}
