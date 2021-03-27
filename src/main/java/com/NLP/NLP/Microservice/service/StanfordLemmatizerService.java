package com.NLP.NLP.Microservice.service;

import com.NLP.NLP.Microservice.dao.CsvRepository;
import com.NLP.NLP.Microservice.model.TextDb;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Slf4j
@Service
public class StanfordLemmatizerService {

    public static final String QUOTE = "\"";
    protected StanfordCoreNLP pipeline;

    //TextDb textDb=new TextDb();

    @Autowired
    private CsvRepository csvRepository;

    public void stanfordLemmatizerService() {

        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");

        // StanfordCoreNLP loads a lot of models, so you probably
        // only want to do this once per execution
        this.pipeline = new StanfordCoreNLP(props);
    }

   public List<String> lemmatize(String documentText)
    {   stanfordLemmatizerService();
        List<String> lemmas = new LinkedList<String>();

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(documentText);

        // run all Annotators on this text
        this.pipeline.annotate(document);

        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {


            // Iterate over all tokens in a sentence
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // Retrieve and add the lemma for each word into the list of lemmas
                lemmas.add(token.get(CoreAnnotations.LemmaAnnotation.class));
                if(!(token.value().equals(QUOTE))&&!(token.lemma().equals(QUOTE))){
                    TextDb t1= new TextDb(token.value(),token.get(CoreAnnotations.LemmaAnnotation.class));
                    log.info("processed: "+ csvRepository.save(t1));

                }

            }
        }


        return lemmas;
    }


}
