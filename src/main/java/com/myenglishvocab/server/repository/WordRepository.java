package com.myenglishvocab.server.repository;

import com.myenglishvocab.server.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByMemberId(Long memberId);
}