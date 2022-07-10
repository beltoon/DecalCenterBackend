package com.tobias.decalcenter.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FileUploadResponse {

    @Id
    private String fileName;

    private String contentType;
    private String url;

    @OneToOne(mappedBy = "fileName", cascade = CascadeType.ALL, orphanRemoval = true)
    private Decal decal;

    public FileUploadResponse(String fileName,
                              String contentType,
                              String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public FileUploadResponse() {
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

    public Decal getDecal() {
        return decal;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDecal(Decal decal) {
        this.decal = decal;
    }
}
