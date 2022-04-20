package com.tiago.desafiosenseup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.desafiosenseup.domain.SensorData;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {

}
