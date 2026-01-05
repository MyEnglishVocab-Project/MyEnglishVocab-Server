package com.myenglishvocab.server.controller;

import com.myenglishvocab.server.dto.WordDto;
import com.myenglishvocab.server.entity.Member;
import com.myenglishvocab.server.entity.Word;
import com.myenglishvocab.server.repository.MemberRepository;
import com.myenglishvocab.server.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WordController {

    private final WordRepository wordRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/{profileId}")
    public List<WordDto> getWordsByProfile(@PathVariable Long profileId) {
        return wordRepository.findByMemberId(profileId).stream()
                .map(WordDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/{profileId}")
    public WordDto addWord(@PathVariable Long profileId, @RequestBody WordDto wordDto) {
        Member member = memberRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        Word word = new Word();
        word.setTerm(wordDto.getTerm());
        word.setDefinition(wordDto.getDefinition());
        word.setLevel(wordDto.getLevel());
        word.setExampleSentence(wordDto.getExampleSentence());
        word.setMeaningOfExampleSentence(wordDto.getMeaningOfExampleSentence());
        word.setMember(member);

        return new WordDto(wordRepository.save(word));
    }

    @DeleteMapping("/{wordId}")
    public void deleteWord(@PathVariable Long wordId) {
        wordRepository.deleteById(wordId);
    }

    @PutMapping("/{wordId}")
    public WordDto updateWord(@PathVariable Long wordId, @RequestBody WordDto wordDto) {
        Word word = wordRepository.findById(wordId)
                .orElseThrow(() -> new RuntimeException("Word not found"));

        word.setTerm(wordDto.getTerm());
        word.setDefinition(wordDto.getDefinition());
        word.setLevel(wordDto.getLevel());
        word.setExampleSentence(wordDto.getExampleSentence());
        word.setMeaningOfExampleSentence(wordDto.getMeaningOfExampleSentence());

        return new WordDto(wordRepository.save(word));
    }
}