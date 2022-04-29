package com.tiago.desafiosenseup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.desafiosenseup.domain.DataStream;
import com.tiago.desafiosenseup.domain.MeasurementUnit;
import com.tiago.desafiosenseup.domain.SensorDevice;
import com.tiago.desafiosenseup.domain.User;
import com.tiago.desafiosenseup.repositories.DataStreamRepository;
import com.tiago.desafiosenseup.repositories.MeasurementUnitRepository;
import com.tiago.desafiosenseup.repositories.SensorDeviceRepository;
import com.tiago.desafiosenseup.repositories.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class DesafioSenseUpApplication implements CommandLineRunner {

	
	@Autowired
	private MeasurementUnitRepository measurementUnitRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SensorDeviceRepository sensorDeviceRepository;
	
	@Autowired
	private DataStreamRepository dataStreamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioSenseUpApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		MeasurementUnit m1 = new MeasurementUnit(null,"ºC","Celsius");
		MeasurementUnit m2 = new MeasurementUnit(null,"mg/m³","Megagram per cubic metre");
		MeasurementUnit m3 = new MeasurementUnit(null,"hPA","Hectopasca");
		MeasurementUnit m4 = new MeasurementUnit(null,"lux","Lux");
		MeasurementUnit m5 = new MeasurementUnit(null,"%","Percent");

		measurementUnitRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
		User u1 = new User(null, "joaosilva", "joaosilva@gmail.com", null);
		User u2 = new User(null, "marialima", "marialima@gmail.com", null);
		
		
		
		SensorDevice sd1 = new SensorDevice(null,"10dd35008a0f4d838c3dc22856660928","sensor 001","Isaac's Room control",u1,null);
		SensorDevice sd2 = new SensorDevice(null,"27b26e48cd674cc38ec45808cf48fa07","Kitchen's freezer sensor (Arduino)","Kitchen's freezer sensor (Arduino)",u1,null);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		sensorDeviceRepository.saveAll(Arrays.asList(sd1,sd2));
		
		DataStream ds1 = new DataStream(null,"b4ea3ba494644200b679ac593f55cb87","temperature",true,sd1,m1,null);
		DataStream ds2 = new DataStream(null,"8961bd9a4d1e439ebf3b86af5b9d5c1f","temperature",true,sd2,m1,null);
		DataStream ds3 = new DataStream(null,"ae194d2b61e0496fbf601f9edcf8b0c5","temperature",true,sd1,m5,null);
		DataStream ds4 = new DataStream(null,"3170f851fd9045ed99e5d86ababdb80e","temperature",true,sd1,m2,null);
		
		dataStreamRepository.saveAll(Arrays.asList(ds1,ds2,ds3,ds4));
	}

}
