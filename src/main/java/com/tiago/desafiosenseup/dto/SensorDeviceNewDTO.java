package com.tiago.desafiosenseup.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tiago.desafiosenseup.domain.SensorDevice;

public class SensorDeviceNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String key;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String label;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String description;
	
	public SensorDeviceNewDTO() {
		
	}
	
	public SensorDeviceNewDTO(SensorDevice obj) {
		id = obj.getId();
		label = obj.getLabel();
		key = obj.getKey();
		description = obj.getDescription();
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

	

}
