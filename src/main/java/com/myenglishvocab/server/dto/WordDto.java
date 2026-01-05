package com.myenglishvocab.server.dto;

import com.myenglishvocab.server.entity.Word;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WordDto {
    private Long id;
    private String term;
    private String definition;
    private Integer level;
    private String exampleSentence;
    private String meaningOfExampleSentence;

    public WordDto(Word word) {
        this.id = word.getId();
        this.term = word.getTerm();
        this.definition = word.getDefinition();
        this.level = word.getLevel();
        this.exampleSentence = word.getExampleSentence();
        this.meaningOfExampleSentence = word.getMeaningOfExampleSentence();
    }
}