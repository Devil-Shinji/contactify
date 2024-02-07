package com.example.contactify.auth.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private String[] protectedResources = {"/api/**"};
}