package com.bmm.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//Bypassing security saying we handling security
//through this automatic security disabled
@Configuration
@EnableWebSecurity
public class securityConfig {

    @Autowired
    UserDetailsService userDetailsService;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf().disable();
//        http.authorizeHttpRequests(requests-> requests.anyRequest().authenticated() );
//        http.formLogin(Customizer.withDefaults());
//        http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsServiceurn() {
////
////        UserDetails user1= User
////                .withDefaultPasswordEncoder()
////                .username("Biradar")
////                .password("B@123")
////                .roles("USER")
////                .build();
////
////        UserDetails user2= User
////                .withDefaultPasswordEncoder()
////                .username("Baliram")
////                .password("B@123")
////                .roles("ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(user1,user2);
////    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
//        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }

@Bean
public AuthenticationProvider authProvider() {
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    return provider;
}





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }




}
