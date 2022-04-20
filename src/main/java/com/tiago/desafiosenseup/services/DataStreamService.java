package com.tiago.desafiosenseup.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.domain.SensorDevice;
import com.tiago.desafiosenseup.dto.DataStreamNewDTO;
import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.repositories.DataStreamRepository;
import com.tiago.desafiosenseup.repositories.MeasurementUnitRepository;
import com.tiago.desafiosenseup.repositories.SensorDeviceRepository;
import com.tiago.desafiosenseup.services.exceptions.ObjectNotFoundException;

@Service
public class DataStreamService {
	
	@Autowired
	private DataStreamRepository repo;
	
	@Autowired
	private MeasurementUnitRepository measurementUnitRepository;
	
	@Autowired
	private SensorDeviceRepository sensorDeviceRepository;
	
	
	
	public DataStream find(Integer id) {
		Optional<DataStream> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + MeasurementUnit.class.getName()));
	}
	
	public List<DataStream> findAll() {
		return repo.findAll();		
	}
	
	public DataStream insert(DataStream obj) {
		obj.setId(null);
		obj.setKey(getRandomHexString());
	
        
		return repo.save(obj);
	}
	
	public DataStream fromDTO(DataStreamNewDTO objDto, String sensorDeviceKey) {
	
		Optional<MeasurementUnit> mu = measurementUnitRepository.findById(objDto.getUnitId());
		Optional<SensorDevice> sd = sensorDeviceRepository.findByKey(sensorDeviceKey);
		
		
		return new DataStream(null,null,objDto.getLabel(),true,sd.get(),mu.get(),null);
	}
	
	public Optional<DataStream> findByKey(String key) {
		
		Optional<DataStream> ds = repo.findByKey(key);
		
		return ds;		
	}
	
	private String getRandomHexString(){
		int numchar = 32;
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchar){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchar);
    }

}
