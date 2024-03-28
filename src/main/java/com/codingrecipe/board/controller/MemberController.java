package com.codingrecipe.board.controller;


import com.codingrecipe.board.dto.MemberDTO;
import com.codingrecipe.board.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join() {

        return "join";
    }


    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/join")
    public String join(MemberDTO memberDTO) {
        System.out.println("memberDTO =" + memberDTO);
        memberService.join(memberDTO);
        return "redirect:/index";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult)  {
            session.setAttribute("user_id", memberDTO.getUser_id());
            return "index";
        } else {
            return "index";
        }
    }

    @PostMapping(value = "/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "index";
    }


}
