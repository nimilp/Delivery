//package com.keralakitchen.delivery.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KeralaKitchenSecurityService implements UserDetailsService
//{
//    private static final Logger log = LoggerFactory.getLogger(KeralaKitchenSecurityService.class);
//    @Value("${spring.security.user.name}")
//    String username;
//
//    @Value("${spring.security.user.password}")
//    String password;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if(this.username.equals(username)){
//            log.info(String.format("The password is %s",password));
//            return User.builder()
//                .username(username)
//                .password(password)
////                .roles("USER")
//                .build();
////
////        return new InMemoryUserDetailsManager(userDetails);
//        } else {
//            throw new UsernameNotFoundException("Access Denied");
//        }
//    }
//
//    @Bean
//    PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    public boolean checkPassword(String rawPassword, String encodedPassword) {
//        return getPasswordEncoder().matches(rawPassword, this.password);
//    }
//}
