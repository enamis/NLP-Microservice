package com.NLP.NLP.Microservice.dao;

import com.NLP.NLP.Microservice.model.TextDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends MongoRepository<TextDb,String> {

}
