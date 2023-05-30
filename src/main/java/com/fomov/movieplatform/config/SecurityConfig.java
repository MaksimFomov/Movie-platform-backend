package com.fomov.movieplatform.config;

import com.fomov.movieplatform.security.CustomUserDetailsService;
import com.fomov.movieplatform.security.JwtAuthenticationFilter;
import com.fomov.movieplatform.security.JwtAuthorizationFilter;
import com.fomov.movieplatform.security.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailsService customUserDetailsService;


    public SecurityConfig(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, CustomUserDetailsService customUserDetailsService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/users/login").permitAll()
                .antMatchers("/api/users/{userId}/orders").hasRole("user")
                .antMatchers("/api/users/{userId}/orders/{orderId}").hasRole("user")
                .antMatchers(HttpMethod.POST, "/api/**").hasRole("admin")
                .antMatchers(HttpMethod.PUT, "/api/**").hasRole("admin")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenUtil))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenUtil, customUserDetailsService))
                .httpBasic();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



