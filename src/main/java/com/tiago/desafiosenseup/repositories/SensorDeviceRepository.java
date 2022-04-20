package com.tiago.desafiosenseup.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiago.desafiosenseup.domain.SensorDevice;
import com.tiago.desafiosenseup.domain.User;

@Repository
public interface SensorDeviceRepository extends JpaRepository<SensorDevice, Integer> {
	
	@Transactional(readOnly=true)
	List<SensorDevice> findByUser(User user);
	
	@Transactional(readOnly=true)
	Optional<SensorDevice> findByKey(String key);
	
	@Transactional(readOnly=true)
	List<SensorDevice> findByDescription(String description);
	
	@Transactional(readOnly=true)
	List<SensorDevice> findByLabel(String label);

}
