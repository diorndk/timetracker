package com.xperiencehr.timetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Slf4j
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        log.info("Initializing in-memory user details service");
        
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        
        UserDetails employee1 = User.builder()
                .username("EMP0001")
                .password(passwordEncoder.encode("emp0001"))
                .roles("EMPLOYEE")
                .build();
        
        UserDetails employee2 = User.builder()
                .username("EMP0002")
                .password(passwordEncoder.encode("emp0002"))
                .roles("EMPLOYEE")
                .build();
        
        UserDetails employee3 = User.builder()
                .username("EMP0003")
                .password(passwordEncoder.encode("emp0003"))
                .roles("EMPLOYEE")
                .build();
        
        UserDetails employee4 = User.builder()
                .username("EMP0004")
                .password(passwordEncoder.encode("emp0004"))
                .roles("EMPLOYEE")
                .build();
        
        log.info("Created in-memory users: admin, EMP0001, EMP0002, EMP0003, EMP0004");
        
        return new InMemoryUserDetailsManager(admin, employee1, employee2, employee3, employee4);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("Configuring security filter chain");
        
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login**", "/error/**", "/css/**", "/js/**", "/WEB-INF/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/report", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        
        return http.build();
    }
}
