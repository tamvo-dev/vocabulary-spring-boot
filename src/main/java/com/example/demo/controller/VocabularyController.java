package com.example.demo.controller;

import com.example.demo.entity.Vocabulary;
import com.example.demo.repository.VocabularyRepository;
import com.example.demo.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Random;

/**
 * @author tamvo
 * @created 11/03/2020 - 10:55 AM
 */

@Controller
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @RequestMapping(value = "/vocabularys", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getVocabularys(){
        List<Vocabulary> vocabularies = vocabularyService.getVocabularys();
        if (vocabularies == null || vocabularies.size() == 0){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(vocabularies, HttpStatus.OK);
    }

    @RequestMapping(value = "/vocabularys/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getVocabulary(@PathVariable("id") int id){
        Vocabulary vocabulary = vocabularyService.getVocabulary(id);
        if (vocabulary.getId() == 0){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(vocabulary, HttpStatus.OK);
    }
}