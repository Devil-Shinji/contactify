package com.example.contactify.auth.config;

import com.example.contactify.auth.properties.AuthProperties;
import com.example.contactify.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {
    private final AuthProperties authProperties;
    private final AuthService authService;

    public AuthConfig(AuthProperties authProperties, AuthService authService) {
        this.authProperties = authProperties;
        this.authService = authService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().authorizeHttpRequests(it -> it
                        .requestMatchers("/api")
                        .permitAll()
                        .requestMatchers(authProperties.getProtectedResources())
                        .authenticated()
                        .anyRequest()
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}