package com.example.reimbursementcalculator.config;

import com.example.reimbursementcalculator.service.OrganisationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
    private OrganisationService organisationService;

    private PasswordEncoder passwordEncoder;
    public Security(OrganisationService organisationService, PasswordEncoder passwordEncoder) {
        this.organisationService = organisationService;
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());
        http.headers(customizer -> customizer.disable());
        return http
                .userDetailsService(organisationService)
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll())
                .formLogin(customizer -> customizer.loginPage("/login")
                        .permitAll())
                .logout(customizer -> customizer.logoutSuccessUrl("/"))
                .build();
    }

}
