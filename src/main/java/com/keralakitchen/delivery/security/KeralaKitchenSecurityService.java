package com.keralakitchen.delivery.security;

import com.keralakitchen.delivery.enums.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KeralaKitchenSecurityService implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(KeralaKitchenSecurityService.class);
    @Value("${spring.security.user.name}")
    String username;

    @Value("${spring.security.user.password}")
    String password;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(this.username.equals(username)){

            log.info(String.format("The password is %s",password));

            UserDetails userDetails =  User.builder()
                .username(username)
                .password(password).roles(Constants.UserType.Admin.name())
                .build();

            return userDetails;
        } else {
            throw new UsernameNotFoundException("Access Denied");
        }
    }

}
