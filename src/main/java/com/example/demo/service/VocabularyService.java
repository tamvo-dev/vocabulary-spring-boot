package com.example.demo.service;

import com.example.demo.entity.Vocabulary;
import com.example.demo.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author tamvo
 * @created 14/03/2020 - 8:58 PM
 */

@Service
public class VocabularyService {

    private static final Random random;

    static {
        random = new Random();
    }

    @Autowired
    VocabularyRepository vocabularyRepository;

    public List<Vocabulary> getVocabularys(){
        int start = random.nextInt(480);
        return vocabularyRepository.getVocabularys(start);
    }

    public Vocabulary getVocabulary(int id){
        // Not null
        return vocabularyRepository.findById(id).get();
    }
}
