package com.yyy.housingtransactions.model.vo;

import com.yyy.housingtransactions.model.House;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class HouseVo extends House {
    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
