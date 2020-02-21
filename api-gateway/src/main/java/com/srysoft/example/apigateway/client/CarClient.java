package com.srysoft.example.apigateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

import com.srysoft.example.apigateway.bean.Car;

@FeignClient("car-service")
public interface CarClient {

	@GetMapping("/cars")
	Resources<Car> readCars();
}
