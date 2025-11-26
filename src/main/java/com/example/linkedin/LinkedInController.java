package com.example.linkedin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LinkedInController {

    @Autowired
    private LinkedInScraperService scraperService;

    @PostMapping("/extractProfile")
    public LinkedInProfile extractProfile(@RequestBody ProfileRequest request) {
        return scraperService.scrapeProfile(request.getLinkedinUrl());
    }

    public static class ProfileRequest {
        private String linkedinUrl;
        public String getLinkedinUrl() { return linkedinUrl; }
        public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }
    }
}