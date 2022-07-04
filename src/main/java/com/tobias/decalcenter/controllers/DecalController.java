package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.DecalDto;
import com.tobias.decalcenter.dtos.DecalInputDto;
import com.tobias.decalcenter.models.FileUploadResponse;
import com.tobias.decalcenter.services.DecalService;
import com.tobias.decalcenter.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;
import java.util.Optional;

@RestController
public class DecalController {

    private final DecalService decalService;
    private final ImageController imageController;

    @Autowired
    public DecalController(DecalService decalService, ImageController imageController) {
        this.decalService = decalService;
        this.imageController = imageController;
    }


    @GetMapping("/decals")
    @Transactional
    public ResponseEntity<List<DecalDto>> getAllDecals(
            @RequestParam(value = "name", required = false) Optional<String> name) {

        List<DecalDto> decalDtos;

        if (name.isEmpty()) {

            decalDtos = decalService.getAllDecals();

        } else {

            decalDtos = decalService.getAllDecalsByName(name.get());

        }
        return ResponseEntity.ok().body(decalDtos);
    }

    @GetMapping("/decals/{id}")
    @Transactional
    public ResponseEntity<Object> getDecal(
            @PathVariable("id") Long id) {

        DecalDto decal = decalService.getDecalById(id);

        return ResponseEntity.ok().body(decal);
    }

    @Transactional
    @PostMapping("/decals/")
      public ResponseEntity<Object> addDecal(
            @RequestBody DecalInputDto decalInputDto) {

        DecalDto decalDto = decalService.addDecal(decalInputDto);

        return ResponseEntity.created(null).body(decalDto);
    }

    @Transactional
    @PostMapping("/decals/file")
    public void createDecalWithFile(
            @RequestBody DecalInputDto decalInputDto,
            @RequestParam ("file") MultipartFile file) {

        FileUploadResponse fileUpload = imageController.singleFileUpload(file);
        String name = fileUpload.getFileName();
        decalService.createDecalWithFile(decalInputDto, name);
    }



    @DeleteMapping("/decals/{id}")
    public ResponseEntity<Object> deleteDecal(
            @PathVariable Long id) {

        decalService.deleteDecal(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decals/{id}")
    public ResponseEntity<Object> updateDecal(
            @PathVariable Long id,
            @RequestBody DecalInputDto newDecal) {

        DecalDto decalDto = decalService.updateDecal(id, newDecal);

        return ResponseEntity.ok().body(decalDto);
    }

    @PutMapping("decals/{decalId}/cars/{carId}")
    public void assignCarToDecal(
            @PathVariable("decalId") Long decalId,
            @PathVariable("carId") Long carId
    ) {
        decalService.assignCarToDecal(decalId, carId);
    }

    @Transactional
    @PostMapping("/decals/{Id}/")
    public void assignImageToDecal(@PathVariable Long decalId,
                                   @RequestBody MultipartFile file) {

        FileUploadResponse decalImage = imageController.singleFileUpload(file);

        decalService.assignImageToDecal(decalImage.getFileName(), decalId);

    }

}
