package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberRecord;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberWirteService {
    final  private MemberRepository memberRepository;
    public Member create(RegisterMemberRecord record){

        /**
         * 목표 - 회원정보(이메일,닉네임,생년월일)을 등록한다.
         * 닉네임 - 10자제한
         *
         */

        var member = Member.builder()
                .nickname(record.nickname())
                .email(record.email())
                .birthDay(record.birthDay())
                .build();
        return memberRepository.create(member);

    }

}
