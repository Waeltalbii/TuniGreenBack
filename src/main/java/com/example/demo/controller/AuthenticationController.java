package com.example.demo.controller;

import com.example.demo.config.AuthenticationRequest;
import com.example.demo.config.AuthenticationResponce;
import com.example.demo.config.RegisterRequest;
import com.example.demo.service.UserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final UserImpl userimpl ;
    @PostMapping("/register")
    public void  register(@RequestBody RegisterRequest request){
        userimpl.signup(request);

    }
    @PostMapping("/authenticate")
    public AuthenticationResponce signin(@RequestBody AuthenticationRequest request){
       return userimpl.signin(request);


    }
}
