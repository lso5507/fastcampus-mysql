package com.example.fastcampusmysql.Controller;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberRecord;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.service.MemberWirteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class MemberController {
    final private MemberWirteService memberWirteService;
    @PostMapping("/members")
    public Member register(@RequestBody RegisterMemberRecord record){
        return memberWirteService.create(record);
    }
}
