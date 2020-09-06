package com.saeid.apiserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping(path = "/message", method = RequestMethod.GET)
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok().body("This is a message");
    }
}
