package com.tiago.desafiosenseup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.domain.SensorDevice;


@Repository
public interface DataStreamRepository extends JpaRepository<DataStream, Integer> {

	
	@Transactional(readOnly=true)
	Optional<DataStream> findByKey(String key);
}
