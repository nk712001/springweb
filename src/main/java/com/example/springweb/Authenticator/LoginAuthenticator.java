package com.example.springweb.Authenticator;

import com.example.springweb.Config.SecurityConfig;
import com.example.springweb.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.SessionManagementFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class LoginAuthenticator {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authPro = new DaoAuthenticationProvider();
//        authPro.setUserDetailsService(userDetailsService());
//        authPro.setPasswordEncoder(passwordEncoder());
//        return authPro;
//    }
    @Bean
    public SecurityFilterChain configurSec(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((req) ->
                        req
                                .requestMatchers("/searchByFields").authenticated()
                                .anyRequest().permitAll()
                )
                .sessionManagement((ses) ->
                                ses
                                        .maximumSessions(1)
                                        .maxSessionsPreventsLogin(true)
                                        .expiredUrl("/login")
//                                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                                .invalidSessionUrl("/?sessionExpired")
                )
                .addFilterBefore(new SecurityConfig(), SessionManagementFilter.class)
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("username")
                        .defaultSuccessUrl("/searchByFields")
                        .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/?logout").permitAll());

        return http.build();
    }


}
