package com.tobias.decalcenter.services;

import com.tobias.decalcenter.dtos.CarDto;
import com.tobias.decalcenter.dtos.CarInputDto;
import com.tobias.decalcenter.exceptions.RecordNotFoundException;
import com.tobias.decalcenter.models.Car;
import com.tobias.decalcenter.repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> getAllCars() {

        List<Car> carList = carRepository.findAll();

        return transferCarListToDtoList(carList);
    }

    public List<CarDto> getAllCarsByName(String name) {

        List<Car> carList = carRepository.findAllCarsByNameEqualsIgnoreCase(name);

        return transferCarListToDtoList(carList);
    }

    public List<CarDto> transferCarListToDtoList(List<Car> cars) {
        List<CarDto> carDtoList = new ArrayList<>();

        for (Car car : cars) {
            CarDto carDto = transferToDto(car);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }

    public CarDto getCarById(Long id) {

        if (carRepository.findById(id).isPresent()) {
            Car car = carRepository.findById(id).get();

            return transferToDto(car);
        } else {
            throw new RecordNotFoundException("No car found...");
        }
    }

    public CarDto addCar(CarInputDto carInputDto) {
        Car car = transferToCar(carInputDto);

        carRepository.save(car);

        return transferToDto(car);
    }

    public void deleteCar(@RequestBody Long id) {
        carRepository.deleteById(id);
    }

    public CarDto updateCar(Long id, CarInputDto carInputDto) {

        if (carRepository.findById(id).isPresent()) {
            Car car = carRepository.findById(id).get();

            Car car1 = transferToCar(carInputDto);
            car1.setId(car.getId());

            carRepository.save(car1);

            return transferToDto(car1);
        } else {
            throw new RecordNotFoundException("No car found...");
        }
    }

    public Car transferToCar(CarInputDto carDto) {
        var car = new Car();

        car.setName(carDto.getName());
        car.setBrand(carDto.getBrand());
        car.setType(carDto.getType());
        car.setCategory(carDto.getCategory());
        return car;
    }

    public CarDto transferToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setBrand(car.getBrand());
        carDto.setType(car.getType());
        carDto.setCategory(car.getCategory());
        return carDto;
    }
}
