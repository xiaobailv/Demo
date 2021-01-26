package com.liushihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
// @RestController
public class UserController {

    @RequestMapping("/index")
    public String index(){
        return "/html/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "/html/login";
    }
}
