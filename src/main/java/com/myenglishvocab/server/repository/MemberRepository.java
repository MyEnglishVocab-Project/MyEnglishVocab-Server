package com.myenglishvocab.server.repository;

import com.myenglishvocab.server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}