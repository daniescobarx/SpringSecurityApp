package com.app.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@PreAuthorize("denyAll()")
@RequestMapping("/auth")
public class TestAuthController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello(){
        return "oi pessoal permitAll";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAnyAuthority('READ')")
    public String helloSecured(){
        return "oi pessoal teste secured ";
    }

    @GetMapping("/hello-secured2")
    public String helloSecured2(){
        return "oi pessoal nao é para passar";
    }

}
