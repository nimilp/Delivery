package com.keralakitchen.delivery.config;

//import com.keralakitchen.delivery.security.KeralaKitchenSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    KeralaKitchenSecurityService keralaKitchenSecurityService;
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return web->web.ignoring().requestMatchers("/swagger*/**","v3/api-docs/*","/docs");
//    }
//
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(AbstractHttpConfigurer::disable)
//
//                .authorizeHttpRequests(authorize -> {
//
//                    authorize.requestMatchers("/docs/*").permitAll();
//                    authorize.requestMatchers("/swagger/*").permitAll();
//                    authorize.requestMatchers("/users").authenticated();
//                })
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults()).build();
//        return httpSecurity.build();
//
//    }



}
