package com.tiago.desafiosenseup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.domain.User;
import com.tiago.desafiosenseup.repositories.UserRepository;
import com.tiago.desafiosenseup.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + MeasurementUnit.class.getName()));
	}
	
	public List<User> findAll() {
		return repo.findAll();		
	}
	

}
