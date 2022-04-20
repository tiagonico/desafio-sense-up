package com.tiago.desafiosenseup.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiago.desafiosenseup.domain.SensorDevice;
import com.tiago.desafiosenseup.dto.DataStreamGetDTO;
import com.tiago.desafiosenseup.dto.DataStreamSensorDeviceDTO;
import com.tiago.desafiosenseup.dto.SensorDeviceGetDTO;
import com.tiago.desafiosenseup.dto.SensorDeviceNewDTO;
import com.tiago.desafiosenseup.services.SensorDeviceService;

@RestController
@RequestMapping(value="/sensor-devices")
public class SensorDeviceResource {

	@Autowired
	private SensorDeviceService service;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findByUser(@PathVariable Integer id) {
		List<SensorDevice> list = service.findByUserId(id);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		SensorDevice obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(@RequestParam(value="key", required = false) String key) {
		
		if(key != null) {
			Optional<SensorDevice> sd = service.findByKey(key);
			
			SensorDeviceGetDTO sensorDeviceGetDTO = new SensorDeviceGetDTO(sd.get());
			
			return ResponseEntity.ok().body(sensorDeviceGetDTO);
		}
		
		List<SensorDevice> list = service.findAll();			

		return ResponseEntity.ok().body(list);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody SensorDeviceNewDTO objDto) {
		SensorDevice obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		SensorDeviceNewDTO newObjDto = new SensorDeviceNewDTO(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObjDto);
	}
	
}
