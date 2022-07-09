package com.tobias.decalcenter.services;

import com.tobias.decalcenter.dtos.DecalDto;
import com.tobias.decalcenter.dtos.DecalInputDto;
import com.tobias.decalcenter.exceptions.RecordNotFoundException;
import com.tobias.decalcenter.models.Car;
import com.tobias.decalcenter.models.Decal;
import com.tobias.decalcenter.models.FileUploadResponse;
import com.tobias.decalcenter.repositories.CarRepository;
import com.tobias.decalcenter.repositories.DecalRepository;

import com.tobias.decalcenter.repositories.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DecalService {

    private final DecalRepository decalRepository;
    private final CarRepository carRepository;
    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public DecalService(DecalRepository decalRepository,
                        CarRepository carRepository,
                        FileUploadRepository fileUploadRepository) {
        this.decalRepository = decalRepository;
        this.carRepository = carRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    public List<DecalDto> getAllDecals() {

        List<Decal> decalList = decalRepository.findAll();

        return transferDecalListToDtoList(decalList);
    }

    public List<DecalDto> getAllDecalsByName(String name) {

        List<Decal> decalList = decalRepository.findAllDecalsByNameEqualsIgnoreCase(name);

        return transferDecalListToDtoList(decalList);
    }

    public List<DecalDto> getAllDecalsByCarId(Long carId) {

        List<Decal> decalList = decalRepository.findAll();

        List<Decal> filteredDecals = decalList.stream()
                .filter(decal -> decal.getCar()
                        .getId().compareTo(carId) == 0)
                .collect(Collectors.toList());

        return transferDecalListToDtoList(filteredDecals);
    }

    public List<DecalDto> transferDecalListToDtoList(List<Decal> decals) {

        List<DecalDto> decalDtoList = new ArrayList<>();

        for (Decal decal : decals) {
            DecalDto decalDto = transferToDto(decal);
            decalDtoList.add(decalDto);
        }
        return decalDtoList;
    }

    public DecalDto getDecalById(Long id) {

        if (decalRepository.findById(id).isPresent()) {
            Decal decal = decalRepository.findById(id).get();

            return transferToDto(decal);
        } else {
            throw new RecordNotFoundException("No decal found...");
        }
    }

    public DecalDto addDecal(DecalInputDto decalInputDto) {

        Decal decal = transferToDecal(decalInputDto);

        decalRepository.save(decal);

        return transferToDto(decal);
    }

    public void createDecalWithFile(DecalInputDto decalInputDto, String name) {

        DecalDto decalDto = addDecal(decalInputDto);
        Long decalId = decalDto.getId();
        assignImageToDecal(name, decalId);
    }

    public void deleteDecal(@RequestBody Long id) {
        decalRepository.deleteById(id);
    }

    public DecalDto updateDecal(Long id, DecalInputDto decalInputDto) {

        if (decalRepository.findById(id).isPresent()) {
            Decal decal = decalRepository.findById(id).get();

            Decal decal1 = transferToDecal(decalInputDto);
            decal1.setId(decal.getId());

            decalRepository.save(decal1);

            return transferToDto(decal1);
        } else {
            throw new RecordNotFoundException("No decal found...");
        }
    }

    public Decal transferToDecal(DecalInputDto decalDto) {

        var decal = new Decal();
        decal.setName(decalDto.getName());
        decal.setCar(decalDto.getCar());
        decal.setDecalPosition(decalDto.getDecalPosition());
        decal.setCompany(decalDto.getCompany());
        decal.setSeries(decalDto.getSeries());
        decal.setFileName(decalDto.getFileName());

        return decal;
    }

    public DecalDto transferToDto(Decal decal) {

        DecalDto decalDto = new DecalDto();
        decalDto.setId(decal.getId());
        decalDto.setName(decal.getName());
        decalDto.setCar(decal.getCar());
        decalDto.setDecalPosition(decal.getDecalPosition());
        decalDto.setCompany(decal.getCompany());
        decalDto.setSeries(decal.getSeries());
        decalDto.setFileName(decal.getFileName());

        return decalDto;
    }

    public void assignCarToDecal(Long decalId, Long carId) {

        var optionalDecal = decalRepository.findById(decalId);
        var optionalCar = carRepository.findById(carId);

        if (optionalDecal.isPresent() && optionalCar.isPresent()) {
            Decal decal = optionalDecal.get();
            Car car = optionalCar.get();
            decal.setCar(car);

            decalRepository.save(decal);

        } else {
            throw new RecordNotFoundException();
        }
    }

    public void assignImageToDecal(String name, Long decalId) {

        Optional<Decal> optionalDecal = decalRepository.findById(decalId);
        Optional<FileUploadResponse> fileUploadResponse = fileUploadRepository.findByFileName(name);

        if (optionalDecal.isPresent() && fileUploadResponse.isPresent()) {

            FileUploadResponse image = fileUploadResponse.get();
            Decal decal = optionalDecal.get();
            decal.setFileName(image);

            decalRepository.save(decal);
        }
    }
}