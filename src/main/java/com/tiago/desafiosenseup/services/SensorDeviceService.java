package com.tiago.desafiosenseup.services;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.domain.SensorDevice;
import com.tiago.desafiosenseup.domain.User;
import com.tiago.desafiosenseup.dto.SensorDeviceNewDTO;
import com.tiago.desafiosenseup.repositories.SensorDeviceRepository;
import com.tiago.desafiosenseup.repositories.UserRepository;
import com.tiago.desafiosenseup.services.exceptions.ObjectNotFoundException;


@Service
public class SensorDeviceService {
	
	@Autowired
	private SensorDeviceRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public SensorDevice insert(SensorDevice obj) {
		obj.setId(null);
		obj.setKey(this.getRandomHexString());
		
		return repo.save(obj);
	}
	
	public SensorDevice find(Integer id) {
		Optional<SensorDevice> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + MeasurementUnit.class.getName()));
	}
	
	public List<SensorDevice> findByUserId(Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! User Id: " + id + ", Tipo: " + SensorDevice.class.getName());
		}else {
			List<SensorDevice> list = repo.findByUser(user.get());
			
			return list;
			
		}		
	}
	
	public Optional<SensorDevice> findByKey(String key) {
		
		Optional<SensorDevice> sd = repo.findByKey(key);
		
		return sd;		
	}
	
	public List<SensorDevice> findByLabel(String label) {
		
		List<SensorDevice> list = repo.findByLabel(label);
		
		return list;		
	}
	
	public List<SensorDevice> findByDescription(String description) {
		
		List<SensorDevice> list = repo.findByDescription(description);
		
		return list;		
	}
	
	public List<SensorDevice> findAll() {
		return repo.findAll();		
	}
	
	public SensorDevice fromDTO(SensorDeviceNewDTO objDto) {
		return new SensorDevice(objDto.getId(),objDto.getKey(),objDto.getLabel(),objDto.getDescription(),null,null);
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
