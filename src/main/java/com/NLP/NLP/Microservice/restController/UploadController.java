package com.NLP.NLP.Microservice.restController;


import com.NLP.NLP.Microservice.dao.CsvRepository;
import com.NLP.NLP.Microservice.model.TextDb;
import com.NLP.NLP.Microservice.service.CsvService;
import com.NLP.NLP.Microservice.service.StanfordLemmatizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UploadController {
    private String content;

    @Autowired
    private CsvService csvService;

    @Autowired
    private StanfordLemmatizerService stanfordLemmatizer;



    @PostMapping("/upload-csv")
    public String uploadCsvFile(@RequestParam("file") MultipartFile file) throws IOException {
         content=csvService.upload(file);
        return "File uploaded";
    }

    @PostMapping("/doLemmatization")
    public List<String> limitizer(@RequestBody List<String> list){
        return stanfordLemmatizer.lemmatize(csvService.convertListToString(list));
    }
    @PostMapping("/doLemmatizationOnText")
    public List<String> limitizer(@RequestBody String text){
        return stanfordLemmatizer.lemmatize(text);
    }

    @Cacheable("getLematizedForm")
    @GetMapping("/getLematizedForm/{word}")
    public List<String> getLematizedForm(@PathVariable String word){
         return limitizer(word);
    }

    @GetMapping("/getWordsStartWith/{param}")
    public List<String> getWordsStartWith(@PathVariable String param){
        return csvService.searchBy(param);

    }



}
