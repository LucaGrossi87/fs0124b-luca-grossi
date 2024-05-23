package com.webapi.webapi.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary uploader() {
        Map<String, String> config=new HashMap<>();
        config.put("cloud_name", "untitled");
        config.put("api_key","536664427886744");
        config.put("api_secret","OksgdLhQnaqV1C8j0ZItnXYkW2c");
        return new Cloudinary(config);
    }
}
