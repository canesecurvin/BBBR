package com.example.capstone.bbbr.configurations.security;

import com.example.capstone.bbbr.configurations.security.jwt.AuthEntryPoint;
import com.example.capstone.bbbr.configurations.security.jwt.JwtTokenUtil;
import com.example.capstone.bbbr.configurations.security.jwt.RequestFilter;
import com.example.capstone.bbbr.configurations.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthEntryPoint unauthorizedException;

    @Bean
    RequestFilter requestFilter(){
        return new RequestFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception{
        return http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedException).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("**/graphql/**").authenticated().and()
                .httpBasic(withDefaults())
                .authenticationProvider(daoAuthenticationProvider())
                .addFilterBefore(requestFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
