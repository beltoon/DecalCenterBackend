package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.models.FileUploadResponse;
import com.tobias.decalcenter.services.DecalService;
import com.tobias.decalcenter.services.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Objects;

@RestController
@CrossOrigin
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Transactional
    @PostMapping("/upload")
    FileUploadResponse singleFileUpload(
            @RequestParam("file") MultipartFile file) {

        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(Objects.requireNonNull(file.getOriginalFilename()))
                .toUriString();

        String contentType = file.getContentType();
        String fileName = imageService.storeFile(file, url);

        return new FileUploadResponse(fileName, contentType, url);
    }

    @Transactional
    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource> downLoadSingleFile(
            @PathVariable String fileName, HttpServletRequest request) {

        Resource resource = imageService.downLoadFile(fileName);
        String mimeType;

        try {

            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        } catch (IOException e) {

            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;

        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline;fileName=" + resource.getFilename()).body(resource);
    }
}