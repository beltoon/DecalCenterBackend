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

    public List<CarDto> getAllCarsByCarName(String carName) {
        List<Car> carList = carRepository.findAllCarsByCarNameEqualsIgnoreCase(carName);
        return transferCarListToDtoList(carList);
    }

    public List<CarDto> transferCarListToDtoList(List<Car> cars) {
        List<CarDto> carDtoList = new ArrayList<>();

        for (Car c : cars) {
            CarDto dto = transferToDto(c);
            carDtoList.add(dto);
        }
        return carDtoList;
    }

    public CarDto getCarById(Long id) {
        if (carRepository.findById(id).isPresent()) {
            Car c = carRepository.findById(id).get();
//            CarDto dto = transferToDto(c);
            return transferToDto(c);
        } else {
            throw new RecordNotFoundException("no car found");
        }
    }

    public CarDto addCar(CarInputDto dto) {
        Car car = transferToCar(dto);

        carRepository.save(car);

        return transferToDto(car);
    }

    public void deleteCar(@RequestBody Long id) {
        carRepository.deleteById(id);
    }

    public CarDto updateCar(Long id, CarInputDto inputDto) {
        if (carRepository.findById(id).isPresent()) {
            Car car = carRepository.findById(id).get();

            Car car1 = transferToCar(inputDto);
            car1.setId(car.getId());

            carRepository.save(car1);

            return transferToDto(car1);
        } else {
            throw new RecordNotFoundException("no car found");
        }
    }

    public Car transferToCar(CarInputDto dto) {
        var car = new Car();

        car.setCarName(dto.getCarName());

        return car;
    }

    public CarDto transferToDto(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setCarName(car.getCarName());

        return dto;
    }
}
