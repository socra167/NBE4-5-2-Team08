package com.team8.project2.domain.member.repository;


import com.team8.project2.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByApiKey(String apiKey);

    Optional<Member> findByMemberId(String MemberId);

    void deleteByMemberId(String MemberId);
}
