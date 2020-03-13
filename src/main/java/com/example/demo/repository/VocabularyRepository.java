package com.example.demo.repository;

import com.example.demo.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tamvo
 * @created 11/03/2020 - 10:36 AM
 */

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    @Query(value = "select * from vocabulary limit :start, 20", nativeQuery = true)
    List<Vocabulary> getVocabularys(@Param("start") int start);
}
