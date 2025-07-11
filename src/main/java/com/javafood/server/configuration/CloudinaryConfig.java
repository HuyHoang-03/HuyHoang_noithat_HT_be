package com.javafood.server.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary configKey() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "ddse0birj");
        config.put("api_key", "336438446151741");
        config.put("api_secret", "Ltrmx6KYyTTQa04QrYUd88-6iuk");
        return new Cloudinary(config);
    }
}
