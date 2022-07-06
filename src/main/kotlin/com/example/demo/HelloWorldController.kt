package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("home")
class HelloWorldController {

    @GetMapping
    fun hello(): ResponseEntity<String> {
        return ResponseEntity.ok("안녕")
    }
}