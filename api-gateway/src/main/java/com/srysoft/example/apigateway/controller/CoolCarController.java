package com.srysoft.example.apigateway.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.srysoft.example.apigateway.bean.Car;
import com.srysoft.example.apigateway.client.CarClient;

@RestController
public class CoolCarController {

	private final CarClient carClient;

	public CoolCarController(CarClient carClient) {
		this.carClient = carClient;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/cool-cars")
	public Collection<Car> coolCars() {
		return carClient.readCars().getContent().stream().filter(this::isCool).collect(Collectors.toList());
		
	}

	private Collection<Car> fallback() {
		return new ArrayList<>();
	}

	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") && !car.getName().equals("Triumph Stag")
				&& !car.getName().equals("Ford Pinto") && !car.getName().equals("Yugo GV");
	}
}
