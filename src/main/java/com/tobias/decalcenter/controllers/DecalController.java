package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.DecalDto;
import com.tobias.decalcenter.dtos.DecalInputDto;
import com.tobias.decalcenter.services.DecalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DecalController {

    private final DecalService decalService;

    @Autowired
    public DecalController(DecalService decalService) {
        this.decalService = decalService;
    }

    @GetMapping("/decals")
    public ResponseEntity<List<DecalDto>> getAllDecals(@RequestParam(value = "name", required = false) Optional<String> name) {

        List<DecalDto> decalDtos;

        if (name.isEmpty()) {

            decalDtos = decalService.getAllDecals();

        } else {

            decalDtos = decalService.getAllDecalsByName(name.get());

        }
        return ResponseEntity.ok().body(decalDtos);
    }

    @GetMapping("/decals/{id}")
    public ResponseEntity<Object> getDecal(@PathVariable("id") Long id) {

        DecalDto decal = decalService.getDecalById(id);

        return ResponseEntity.ok().body(decal);
    }

    @PostMapping("/decals")
    public ResponseEntity<Object> addDecal(@RequestBody DecalInputDto decalInputDto) {

        DecalDto decalDto = decalService.addDecal(decalInputDto);

        return ResponseEntity.created(null).body(decalDto);
    }

    @DeleteMapping("/decals/{id}")
    public ResponseEntity<Object> deleteDecal(@PathVariable Long id) {

        decalService.deleteDecal(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decals/{id}")
    public ResponseEntity<Object> updateDecal(@PathVariable Long id, @RequestBody DecalInputDto newDecal) {

        DecalDto decalDto = decalService.updateDecal(id, newDecal);

        return ResponseEntity.ok().body(decalDto);
    }

    @PutMapping("decals/{id}/cars/{carId}")
    public void assignCartoDecal(
            @PathVariable("id") Long id,
            @PathVariable("carId") Long carId) {
        decalService.assignCarToDecal(id, carId);
    }


//    @PutMapping("/{decalId}/cars/{carId}")
//    Decal assignCarToDecal(
//            @PathVariable Long decalId,
//            @PathVariable Long carId
//    ) {
//        Decal decal = decalRepository.findById(decalId).get();
//        Car car = carRepository.findById(carId).get();
//        decal.setCar(car);
//        return decalRepository.save(decal);
//    }
}
