package com.example.demo.controller;

import com.example.demo.model.Garbage_can;
import com.example.demo.service.implementation.Garbage_CanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Garbage_Can")
@CrossOrigin("*")
public class Garbage_CanController {
    private final Garbage_CanServiceImpl garbageCanService;
    @PostMapping("/addGarbagecan")
    public Garbage_can addGarbagecan(@RequestBody Garbage_can garbageCan){
        return garbageCanService.addGarbagecan(garbageCan);
    }
}
