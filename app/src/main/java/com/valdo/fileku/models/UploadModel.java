package com.valdo.fileku.models;

public class UploadModel {
    private  String username, namaFile;

    public UploadModel(String username, String namaFile) {
        this.username = username;
        this.namaFile = namaFile;
    }

    public UploadModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }
}
