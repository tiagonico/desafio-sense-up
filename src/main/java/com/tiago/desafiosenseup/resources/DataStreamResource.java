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

import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.dto.DataStreamGetDTO;
import com.tiago.desafiosenseup.dto.DataStreamNewDTO;
import com.tiago.desafiosenseup.services.DataStreamService;

@RestController
@RequestMapping(value="/data-streams")
public class DataStreamResource {

	@Autowired
	private DataStreamService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		DataStream obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(@RequestParam(value="key", required = false) String key) {
				
		if(key != null) {
			Optional<DataStream> ds = service.findByKey(key);
			
			DataStreamGetDTO dsGetDTO = new DataStreamGetDTO(ds.get());
			
			return ResponseEntity.ok().body(dsGetDTO);
		}
		
		List<DataStream> list = service.findAll();			

		return ResponseEntity.ok().body(list);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestParam(value="key", required = true) String key, 
			@Valid @RequestBody DataStreamNewDTO objDto) {
		
		DataStream obj = service.fromDTO(objDto,key);
		
		obj = service.insert(obj);
		
		DataStreamNewDTO newObjDto = new DataStreamNewDTO(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newObjDto);
	}
}
