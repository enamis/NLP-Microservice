package com.NLP.NLP.Microservice.dao;

import com.NLP.NLP.Microservice.model.TextDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CsvRepository extends MongoRepository<TextDb,String> {

    List<TextDb> findByNormalTextStartingWith(String regexp);

}
