package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;

public record RegisterMemberRecord(
        String email,
        String nickname,
        LocalDate birthDay
) {

}
