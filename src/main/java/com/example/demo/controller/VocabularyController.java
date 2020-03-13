package com.example.demo.controller;

import com.example.demo.entity.Vocabulary;
import com.example.demo.repository.VocabularyRepository;
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

    private static final Random random;

    static {
        random = new Random();
    }

    @Autowired
    VocabularyRepository vocabularyRepository;

    @RequestMapping(value = "/vocabularys", method = RequestMethod.GET)
    public ResponseEntity<Object> getVocabularys(){
        int start = random.nextInt(480);
        List<Vocabulary> vocabularies = vocabularyRepository.getVocabularys(start);
        if (vocabularies == null){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(vocabularies, HttpStatus.OK);
    }

    @RequestMapping(value = "/vocabularys/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getVocabulary(@PathVariable("id") int id){
        Vocabulary vocabulary = vocabularyRepository.findById(id).get();
        if (vocabulary.getId() == 0){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(vocabulary, HttpStatus.OK);
    }
}