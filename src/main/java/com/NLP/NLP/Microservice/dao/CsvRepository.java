package com.NLP.NLP.Microservice.dao;

import com.NLP.NLP.Microservice.model.CsvTextMODEL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends MongoRepository<CsvTextMODEL,String> {

}
