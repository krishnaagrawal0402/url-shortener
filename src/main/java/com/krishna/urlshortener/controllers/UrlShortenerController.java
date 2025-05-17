package com.krishna.urlshortener.controllers;

import com.krishna.urlshortener.models.UrlMapping;
import com.krishna.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("URL Shortener is running!");
    }
    @PostMapping("/api/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody UrlMapping urlMapping) {
        String shortUrl = urlShortenerService.shortenUrl(urlMapping.getOriginalUrl());
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        if (originalUrl != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found!");
        }
    }
}
