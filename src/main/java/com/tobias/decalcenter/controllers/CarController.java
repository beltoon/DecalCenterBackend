package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.CarDto;
import com.tobias.decalcenter.dtos.CarInputDto;
import com.tobias.decalcenter.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(
            @RequestParam(value = "carName", required = false) Optional<String> name) {

        List<CarDto> carDtos;

        if (name.isEmpty()) {

            carDtos = carService.getAllCars();

        } else {

            carDtos = carService.getAllCarsByName(name.get());

        }

        return ResponseEntity.ok().body(carDtos);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(
            @PathVariable("id") Long id) {

        CarDto car = carService.getCarById(id);

        return ResponseEntity.ok().body(car);
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> addCar(
            @RequestBody CarInputDto carInputDto) {

        CarDto carDto = carService.addCar(carInputDto);

        return ResponseEntity.created(null).body(carDto);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> deleteCar(
            @PathVariable Long id) {

        carService.deleteCar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(
            @PathVariable Long id,
            @RequestBody CarInputDto newCar) {

        CarDto carDto = carService.updateCar(id, newCar);

        return ResponseEntity.ok().body(carDto);
    }
}