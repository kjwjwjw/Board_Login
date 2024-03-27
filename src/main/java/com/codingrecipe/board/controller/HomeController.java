package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {


    @GetMapping("/")
    public String index() {

        System.out.println("HELLO");
        return "index";
    }

    @GetMapping("/index")
    public String indexForm() {


        return "index";
    }




}
