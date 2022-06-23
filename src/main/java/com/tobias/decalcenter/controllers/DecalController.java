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
}
