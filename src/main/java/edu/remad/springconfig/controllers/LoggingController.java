package edu.remad.springconfig.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logging")
public class LoggingController {

    @GetMapping("/getLogs")
    public ResponseEntity<String> logging() {
        return new ResponseEntity<>("logging/springsecuirtyevening1", HttpStatus.OK);
    }
}