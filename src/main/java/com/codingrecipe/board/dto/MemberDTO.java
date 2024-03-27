package com.codingrecipe.board.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

    private int idx;

    private String user_id;

    private String name;

    private String pw;


}
