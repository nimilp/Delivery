package com.keralakitchen.delivery.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Slf4j
@Configuration(value = "deliverySecurityConfig")
@EnableWebSecurity()
public class DeliverySecurityConfig {
    @Value("${spring.security.ignoreList}")
    String[] ignoreList;
//    @Bean
//    public WebSecurityCustomizer ignoringCustomizer() {
//        log.info("We are ignoring the patterns{}", Arrays.toString(ignoreList));
//        return (web) -> web.ignoring().requestMatchers( ignoreList);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        log.info("We are ignoring the patterns {} in filter chain", Arrays.toString(ignoreList));

        return httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests( authorize->{
                    authorize.requestMatchers(ignoreList).permitAll()
                    .anyRequest().authenticated();
                })
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults()).build();
//
//        log.info("We are in {}", this.getClass().getName());
//////        return httpSecurity.csrf( csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        return httpSecurity.csrf(Customizer.withDefaults())
//                .authorizeHttpRequests(authorize -> {
////                        authorize.anyRequest().authenticated();
//                    authorize.anyRequest().permitAll();
//                }).httpBasic(Customizer.withDefaults()).cors(AbstractHttpConfigurer::disable).build();
    }



}
