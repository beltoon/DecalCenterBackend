package com.tobias.decalcenter.services;

import com.tobias.decalcenter.dtos.DecalDto;
import com.tobias.decalcenter.dtos.DecalInputDto;
import com.tobias.decalcenter.exceptions.RecordNotFoundException;
import com.tobias.decalcenter.models.Decal;
import com.tobias.decalcenter.repositories.CarRepository;
import com.tobias.decalcenter.repositories.DecalRepository;
import com.tobias.decalcenter.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecalService {

    private final DecalRepository decalRepository;

    private final CarRepository carRepository;

    private final EventRepository eventRepository;

    public DecalService(DecalRepository decalRepository, CarRepository carRepository, EventRepository eventRepository) {
        this.decalRepository = decalRepository;
        this.carRepository = carRepository;
        this.eventRepository = eventRepository;
    }

    public List<DecalDto> getAllDecals() {
        List<Decal> decalList = decalRepository.findAll();
        return transferDecalListToDtoList(decalList);
    }

    public List<DecalDto> getAllDecalsByName(String name) {
        List<Decal> decalList = decalRepository.findAllDecalsByNameEqualsIgnoreCase(name);
        return transferDecalListToDtoList(decalList);
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
        decal.setCreator(decalDto.getCreator());
        decal.setCompany(decalDto.getCompany());
        decal.setSeries(decalDto.getSeries());
        return decal;
    }

    public DecalDto transferToDto(Decal decal) {
        DecalDto decalDto = new DecalDto();
        decalDto.setId(decal.getId());
        decalDto.setName(decal.getName());
        decalDto.setCar(decal.getCar());
        decalDto.setCreator(decal.getCreator());
        decalDto.setCompany(decal.getCompany());
        decalDto.setSeries(decal.getSeries());
        return decalDto;
    }

    public void assignCarToDecal(Long decalId, Long carId) {
        var optionalDecal = decalRepository.findById(decalId);
        var optionalCar = carRepository.findById(carId);

        if (optionalDecal.isPresent() && optionalCar.isPresent()) {
            var decal = optionalDecal.get();
            var car = optionalCar.get();

            decal.setCar(car);
            decalRepository.save(decal);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void addDecalToEvent(Long decalId, Long eventId) {
        var optionalEvent = eventRepository.findById(eventId);
        var optionalDecal = decalRepository.findById(decalId);

        if (optionalEvent.isPresent() && optionalDecal.isPresent()) {
            var event = optionalEvent.get();
            var decal = optionalDecal.get();


            event.eventDecals.add(decal);
            eventRepository.save(event);
        } else {
            throw new RecordNotFoundException();
        }
    }

}