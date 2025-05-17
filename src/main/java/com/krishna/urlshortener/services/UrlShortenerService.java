package com.krishna.urlshortener.services;

import com.krishna.urlshortener.models.UrlMapping;
import com.krishna.urlshortener.repositories.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public String shortenUrl(String originalUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortUrl(generateShortUrl());
        urlMappingRepository.save(mapping);
        return mapping.getShortUrl();
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMapping mapping = urlMappingRepository.findByShortUrl(shortUrl);
        return mapping != null ? mapping.getOriginalUrl() : null;
    }

    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
