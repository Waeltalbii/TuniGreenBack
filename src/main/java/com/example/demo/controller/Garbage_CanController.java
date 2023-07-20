package com.example.demo.controller;

import com.example.demo.model.Garbage_can;
import com.example.demo.service.implementation.Garbage_CanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Garbage_Can")
public class Garbage_CanController {
    private final Garbage_CanServiceImpl garbageCanService;
    @PostMapping("/addGarbagecan")
    public Garbage_can addGarbagecan(@RequestBody Garbage_can garbageCan){
        return garbageCanService.addGarbagecan(garbageCan);
    }
}
