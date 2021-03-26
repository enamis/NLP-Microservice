package com.NLP.NLP.Microservice.service;
import com.NLP.NLP.Microservice.dao.CsvRepository;
import edu.stanford.nlp.ie.machinereading.BasicEntityExtractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;


@Service
public class CsvService {

    public static final String COMMA = ",";
    @Value("${csvFile.path}")
    public String uploadDir;

    @Autowired
    private CsvRepository csvRepository;
    private BasicEntityExtractor pipeline;

    public String upload(MultipartFile file)  {
            try {
                Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
                Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                String content = Files.readString(copyLocation, StandardCharsets.US_ASCII);

                return content;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Could not store file " + file.getOriginalFilename()
                        + ". Please try again!");
                return null;
            }
    }
    public List<String> splitToWords(String text){
            return  Arrays.asList(text.split(COMMA));
    }
    public String convertListToString(List<String> list){
        String listString = "";

        for (String s : list)
        {
            listString += s + "\t";
        }

        return listString;

    }







}
