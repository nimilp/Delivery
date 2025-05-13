package com.keralakitchen.delivery.config;

import com.keralakitchen.delivery.security.DeliveryAuthenticationProvider;
import com.keralakitchen.delivery.security.KeralaKitchenSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)


                .authorizeHttpRequests(authorize -> {

                    authorize.requestMatchers("/docs/*","/swagger-ui/**", "/swagger/**","/v3/api-docs").permitAll()
//                        .requestMatchers("/swagger/*").permitAll();
//                    authorize.requestMatchers("/users").authenticated();
                    .anyRequest().authenticated();
                })
//                .httpBasic(Customizer.withDefaults());
                .formLogin(Customizer.withDefaults()).build();
        return httpSecurity.build();

    }



}
