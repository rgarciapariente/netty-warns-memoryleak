package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
class ApiRestController {

    private Logger log = Logger.getLogger("ApiRestController");

    @GetMapping(value = "/warn")
    public ResponseEntity<String> warn() {
        log.info("Info message");
        return ResponseEntity.ok("Ok");
    }


}