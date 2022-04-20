package com.tiago.desafiosenseup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.domain.SensorData;
import com.tiago.desafiosenseup.dto.SensorDataNewDTO;
import com.tiago.desafiosenseup.repositories.DataStreamRepository;
import com.tiago.desafiosenseup.repositories.MeasurementUnitRepository;
import com.tiago.desafiosenseup.repositories.SensorDataRepository;
import com.tiago.desafiosenseup.services.exceptions.ObjectNotFoundException;

@Service
public class SensorDataService {
	
	@Autowired
	private SensorDataRepository repo;
	
	@Autowired
	private MeasurementUnitRepository measurementUnitRepository;
	
	@Autowired
	private DataStreamRepository dataStreamRepository;
	
	public SensorData find(Integer id) {
		Optional<SensorData> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + MeasurementUnit.class.getName()));
	}
	
	public List<SensorData> findAll() {
		return repo.findAll();		
	}
	
	public SensorData insert(SensorData obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}	
	
	public SensorData fromDTO(SensorDataNewDTO objDto, String dataStreamKey) {
		
		Optional<DataStream> ds = dataStreamRepository.findByKey(dataStreamKey);
		Optional<MeasurementUnit> mu = measurementUnitRepository.findById(ds.get().getUnitId());
		
		return new SensorData(null,objDto.getTimestamp(),objDto.getValue(),mu.get(),ds.get());
	}

}
