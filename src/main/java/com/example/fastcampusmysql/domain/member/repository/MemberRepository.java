package com.example.fastcampusmysql.domain.member.repository;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberRecord;
import com.example.fastcampusmysql.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * NameedParameterJdbcTemplate 사용
 *
 */
@RequiredArgsConstructor
@Repository
public class MemberRepository {
    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Member create(Member member){
        if(member.getId()==null){
            return this.insert(member);
        }else {
            return this.update(member);
        }
    }
    private Member insert(Member member){
        /**
         * SimpleJdbcInsert - 곧장 삽입된 데이터의 primary key 값을 얻고 싶어 사용
         * BeanPropertySqlParameterSource Member 도메인을 매핑하기 위해? 사용.
         */
        SimpleJdbcInsert simpleJdbcInsert=  new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName("Member")
                .usingGeneratedKeyColumns("id");
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        long id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return Member.builder()
                .id(id)
                .email(member.getEmail())
                .birthDay(member.getBirthDay())
                .nickname(member.getNickname())
                .build();

    }
    private Member update(Member member){
        //TODO
        return member;
    }
}
