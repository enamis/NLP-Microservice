package com.NLP.NLP.Microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor

public class TextDb {

    @Id
    private String normalText;

    private String lemaText;


}
