package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {
    final private Long id;
    private String email;
    private String nickname;
    private LocalDate birthDay;
    private LocalDateTime createdAt;
    final  private int nicknameLength=10;
    private void validateNickname(String nickname){
        Assert.isTrue(nickname.length()<nicknameLength,"닉네임 길이가 초과되었습니다");
    }
    @Builder
    public Member(Long id, String email, String nickname, LocalDate birthDay, LocalDateTime createdAt) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);
        this.birthDay = Objects.requireNonNull(birthDay);
        this.createdAt = createdAt== null?LocalDateTime.now():createdAt;

    }
}
