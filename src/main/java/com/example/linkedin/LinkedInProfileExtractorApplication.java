package com.example.linkedin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkedInProfileExtractorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LinkedInProfileExtractorApplication.class, args);
        System.out.println("LinkedIn Profile Extractor Running...");
    }
}
