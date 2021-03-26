package com.NLP.NLP.Microservice.restController;


import com.NLP.NLP.Microservice.model.CsvTextMODEL;
import com.NLP.NLP.Microservice.service.CsvService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
public class UploadController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/upload-csv")
    public String uploadCsvFile(@RequestParam("file") MultipartFile file) throws IOException {
         csvService.upload(file);
        return "File uploaded";
    }



}
