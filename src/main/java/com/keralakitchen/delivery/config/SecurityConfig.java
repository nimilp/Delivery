package com.keralakitchen.delivery.config;

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

        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                        authorize.anyRequest().authenticated();
                        }).httpBasic(Customizer.withDefaults()).build();

//                    authorize.requestMatchers("/swagger-ui/**", "/v3/api-docs","/dummy/*").permitAll())
//                    authorize.requestMatchers("/users/**").authenticated()


//                    authorize.requestMatchers("/docs/*","/users/**").hasAuthority(Constants.UserType.Admin.name())
//                            .anyRequest().authenticated())
//                     .httpBasic(Customizer.withDefaults())
//                }).httpBasic(Customizer.withDefaults())
//                au


//        httpSecurity.formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();

//        return http.addFilterAfter(new AuditInterceptor(), AnonymousAuthenticationFilter.class)
//                .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/private/**"))
//                        .authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/public/showProducts"))
//                        .permitAll())
//                .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/public/registerUser"))
//                        .anonymous())
//                .build();

    }



}
