package com.tiago.desafiosenseup.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.domain.SensorData;

public class DataStreamNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String key;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String label;
	
	private Integer unitId;
	
	private Integer deviceId;
	
	private List<SensorData> sensorDatas =  new ArrayList<>();
	
	public DataStreamNewDTO() {
		
	}
	
	public DataStreamNewDTO(DataStream obj) {
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

}
