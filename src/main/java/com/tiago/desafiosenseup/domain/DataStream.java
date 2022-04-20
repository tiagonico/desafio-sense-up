package com.tiago.desafiosenseup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"id","key","label","unitId","deviceId","measurementCount"})
public class DataStream implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String key;
	private String label;
	private boolean enabled;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "sensor_device_id")
	private SensorDevice sensorDevice;
	
	@ManyToOne
	@JoinColumn(name = "measurement_unit_id")
	private MeasurementUnit measurementUnit;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dataStream")
	private List<SensorData> sensorDatas =  new ArrayList<>();
	
	//Constructors
	
	public DataStream() {
		
	}	

	public DataStream(Integer id, String key, String label, boolean enabled, SensorDevice sensorDevice,
			MeasurementUnit measurementUnit, List<SensorData> sensorDatas) {
		this.id = id;
		this.key = key;
		this.label = label;
		this.enabled = enabled;
		this.sensorDevice = sensorDevice;
		this.measurementUnit = measurementUnit;
		this.sensorDatas = sensorDatas;
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

	@JsonIgnore
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public SensorDevice getSensorDevice() {
		return sensorDevice;
	}

	public void setSensorDevice(SensorDevice sensorDevice) {
		this.sensorDevice = sensorDevice;
	}

	@JsonIgnore
	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	@JsonIgnore
	public List<SensorData> getMeasurements() {
		return sensorDatas;
	}

	public void setSensorDatas(List<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}
	
	public Integer getMeasurementCount() {
		return this.sensorDatas.size();
	}
	
	public Integer getDeviceId() {
		return this.getSensorDevice().getId();
	}
	
	public Integer getUnitId() {
		return this.getMeasurementUnit().getId();
	}
	
	
	
	
}
