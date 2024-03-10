package com.codingrecipe.board.repository;

import com.codingrecipe.board.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;

    public void join(MemberDTO memberDTO) { sql.insert("Member.join", memberDTO);}

}
