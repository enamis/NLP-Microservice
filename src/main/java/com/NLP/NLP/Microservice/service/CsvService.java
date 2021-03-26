package com.NLP.NLP.Microservice.service;
import com.NLP.NLP.Microservice.dao.CsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class CsvService {

    public static final String COMMA = ",";
    @Value("${csvFile.path}")
    public String uploadDir;

    @Autowired
    private CsvRepository csvRepository;

    public String upload(MultipartFile file)  {
            try {
                Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
                Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                String content = Files.readString(copyLocation, StandardCharsets.US_ASCII);
                System.out.println("content "+ content);
                return content;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Could not store file " + file.getOriginalFilename()
                        + ". Please try again!");
                return null;
            }
        }

        public List<String> splitToWords(String content){
            return  Arrays.asList(content.split(COMMA));
        }

}
