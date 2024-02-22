package com.example.springweb.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SecurityConfig extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            int maxInactiveInterval = 30000;
            long lastAccessedTime = session.getLastAccessedTime();
            if (System.currentTimeMillis() - lastAccessedTime > maxInactiveInterval) {
                SecurityContextHolder.clearContext();
                session.invalidate();
                System.out.println("session----" + (System.currentTimeMillis() - lastAccessedTime) + "\n maxInactiveInterval--" + maxInactiveInterval);
            }
        }
        filterChain.doFilter(request, response);
    }
}
