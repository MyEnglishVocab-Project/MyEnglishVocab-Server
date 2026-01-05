package com.myenglishvocab.server.controller;

import com.myenglishvocab.server.dto.MemberDto;
import com.myenglishvocab.server.entity.Member;
import com.myenglishvocab.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping
    public List<MemberDto> getProfiles() {
        return memberRepository.findAll().stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MemberDto createProfile(@RequestBody MemberDto memberDto) {
        Member member = new Member(memberDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberDto(savedMember);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
}