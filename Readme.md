# NLP Microservice

In this microservice we will be able to Preprocess **Text** data and store the data into **MongoDB** database.

# Technical Stack

The Technical Stack composed by :
- **Spring Boot**:
    - Spring Data for DAO
    - Spring MVC

- **Maven Dependencies**:
    - Lombok for code Refactoring
    - Swagger & Swagger-UI for API Docs
    - ...

## Mandatory Features

- [ ] Upload Xml/CSV Files to Microservices
- [ ] Open & Read File CSV with Java/Spring
- [ ] Parse Text Content with Java
- [ ] Process the text content with Lematization process
- [ ] Split text to words and store them to database
- [ ] Use **Github** as Code Repository
### Endpoint's
#### Get

> **/getLematizedForm/{word}**
- the upper mapping return the lemmetized form of given word
    - the endpoint **need to return exception if the Given param contain more than one word**
        - ex: "espace" = one word, "l'espace" = one word, ~~"les espaces" = two words~~
> **/getWordsStartWith** param => startwith = "voi"
-the endpoint return all the **normal words** in the db starting with given param startwith
-ex: param = "voi" result list of words :  [ voiture, vois, voie ]
#### Post
> **/doLemmatization** body ; list of words
- the Upper endpoint process the list of words and lemmatiz it and store it with returning result of lematization
    - ex : [voitures, filles, fils] ->  [voiture, fille, fil]
> **/doLemmatizationOnText** body ; text
- the upper endpoint take text on body and return lemmetized text

## Architecture
- [ ] **Config** : All the configurations beans
- [  ] **Model**: All the entities and models
- [ ] **Dao**: All the Repositories for DAO Layer
- [ ] **Service**: All the Service beans that would interact with DAO Layer and controller Layer
- [ ] **RestController**: All the endpoint's

> naming of the packages are not capitalized : **service** and not ~~Service~~

## Nice To have

Implement cache using spring boot cache system to **enhance performance** on the endpoint's.


