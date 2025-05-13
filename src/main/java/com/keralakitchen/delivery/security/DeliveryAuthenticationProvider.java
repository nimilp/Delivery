package com.keralakitchen.delivery.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeliveryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsService keralaKitchenSecurityService;


    PasswordEncoder passwordEncoder;

    DeliveryAuthenticationProvider(UserDetailsService userDetailsService){
        this.keralaKitchenSecurityService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = keralaKitchenSecurityService.loadUserByUsername(authentication.getName());
        log.debug(authentication.getName());
        log.debug(authentication.getCredentials().toString());
        if(passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
