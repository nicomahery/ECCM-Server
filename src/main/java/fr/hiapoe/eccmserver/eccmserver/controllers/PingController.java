package fr.hiapoe.eccmserver.eccmserver.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ping", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class PingController {
    @GetMapping
    public ResponseEntity<String> getPing() {
        return ResponseEntity.ok("pong");
    }
}
