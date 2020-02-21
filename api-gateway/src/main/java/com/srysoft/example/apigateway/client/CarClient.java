package com.srysoft.example.apigateway.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.srysoft.example.apigateway.bean.Car;
import org.springframework.hateoas.Resources;

@FeignClient("car-service")
public interface CarClient {

	Resources<Car> readCars();
}
