package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.dto.MemberDTO;
import com.codingrecipe.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(MemberDTO memberDTO) {
        memberRepository.join(memberDTO);
    }


    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if ( loginMember != null ) {
            return true;

        } else {
            return false;
        }
    }
}