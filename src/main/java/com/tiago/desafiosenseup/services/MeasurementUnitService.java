package com.tiago.desafiosenseup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.repositories.MeasurementUnitRepository;
import com.tiago.desafiosenseup.services.exceptions.ObjectNotFoundException;

@Service
public class MeasurementUnitService {
	
	@Autowired
	private MeasurementUnitRepository repo;
	
	
	public MeasurementUnit find(Integer id) {
		Optional<MeasurementUnit> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + MeasurementUnit.class.getName()));
	}
	
	public List<MeasurementUnit> findAll() {
		return repo.findAll();		
	}
	

}
