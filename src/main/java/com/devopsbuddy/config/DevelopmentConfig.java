package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailSerive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by j_mha on 3/12/2018.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///C:/workspace/devopsbuddy/application-dev.properties")
public class DevelopmentConfig {
    @Bean
    public EmailService emailService(){
        return new MockEmailSerive();
    }
}
