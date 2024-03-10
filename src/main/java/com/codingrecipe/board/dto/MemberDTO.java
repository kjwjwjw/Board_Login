package com.codingrecipe.board.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

    private Long id;

    private String userId;

    private String userName;

    private String userPw;


}
