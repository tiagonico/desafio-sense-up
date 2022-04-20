package com.tiago.desafiosenseup.resources;

import java.net.URI;
import java.util.List;

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

import com.tiago.desafiosenseup.domain.SensorData;
import com.tiago.desafiosenseup.dto.SensorDataNewDTO;
import com.tiago.desafiosenseup.services.SensorDataService;

@RestController
@RequestMapping(value="/sensor-datas")
public class SensorDataResource {

	@Autowired
	private SensorDataService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		SensorData obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<SensorData> list = service.findAll();

		return ResponseEntity.ok().body(list);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestParam(value="key", required = true) String key, 
			@Valid @RequestBody SensorDataNewDTO objDto) {
		
		SensorData obj = service.fromDTO(objDto,key);
		
		obj = service.insert(obj);
		
		SensorDataNewDTO newObjDto = new SensorDataNewDTO(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newObjDto);
	}
}
