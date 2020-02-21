package com.srysoft.example.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srysoft.example.carservice.entity.Car;


@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
