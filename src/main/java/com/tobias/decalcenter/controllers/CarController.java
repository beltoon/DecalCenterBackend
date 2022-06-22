package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.CarDto;
import com.tobias.decalcenter.dtos.CarInputDto;
import com.tobias.decalcenter.models.Car;
import com.tobias.decalcenter.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(@RequestParam(value = "carName", required = false) Optional<String> carName) {

        List<CarDto> dtos;

        if (carName.isEmpty()){

            dtos = carService.getAllCars();

        } else {

            dtos = carService.getAllCarsByCarName(carName.get());

        }

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable("id") Long id) {
        CarDto car = carService.getCarById(id);
        return ResponseEntity.ok().body(car);
    }

    @PostMapping("/cars")
//@RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<Object> addCar(@RequestBody CarInputDto carInputDto) {

        CarDto dto = carService.addCar(carInputDto);

        return ResponseEntity.created().body(dto);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {

        carService.deleteCar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cars/{id}")
//    @RequestMapping(value = "/cars/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCar(@PathVariable Long id, @RequestBody CarInputDto newCar) {

        CarDto dto = carService.updateCar(id, newCar);

        return ResponseEntity.ok().body(dto);
    }
}
