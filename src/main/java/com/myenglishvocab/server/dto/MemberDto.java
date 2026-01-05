package com.myenglishvocab.server.dto;

import com.myenglishvocab.server.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}