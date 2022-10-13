package com.example.project.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {
    @GetMapping
    public String get(){
        return "requisisão GET";
    }
    @PostMapping
    public String post(){
        return "requisisão POST";
    }
    @PutMapping
    public String put(){
        return "requisisão PUT";
    }
    @PatchMapping
    public String path(){
        return "requisisão PATH";
    }
    @DeleteMapping
    public String delete(){
        return "requisisão DELETE";
    }
}
