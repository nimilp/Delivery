package com.keralakitchen.delivery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.security.ignore}")
    String[] ignore;
    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers( ignore);
    }
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        return httpSecurity.csrf( csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        return httpSecurity.csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> {
                        authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults()).build();
    }



}
