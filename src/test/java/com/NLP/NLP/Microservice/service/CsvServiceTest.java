package com.NLP.NLP.Microservice.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CsvServiceTest {
    @Autowired
    private CsvService csvService;
    @Test
    void upload() {

    }

    @Test
    void splitToWords() {
        List<String>list = csvService.splitToWords("amine,imane");
        assertEquals(list.get(0), "amine");
    }

}