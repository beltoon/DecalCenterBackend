package com.tobias.decalcenter.repositories;

import com.tobias.decalcenter.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllCarsByCarNameEqualsIgnoreCase(String carName);
}
