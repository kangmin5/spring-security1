package com.utosoftware.security1client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "여기는 시큐리티1 의 헬로우 컨트롤러입니다.";
    }
}
