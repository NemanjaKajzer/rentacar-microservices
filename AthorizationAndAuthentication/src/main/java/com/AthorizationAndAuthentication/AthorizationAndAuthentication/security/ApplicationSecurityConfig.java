package com.AthorizationAndAuthentication.AthorizationAndAuthentication.security;



//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.header.writers.StaticHeadersWriter;
//
//import javax.crypto.SecretKey;
//
//import com.AthorizationAndAuthentication.AthorizationAndAuthentication.security.*;
//import com.AthorizationAndAuthentication.AthorizationAndAuthentication.security.jwt.*;
//import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.*;
//import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.*;


//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    public class ApplicationSecurityConfig {
/*
    private final PasswordEncoder passwordEncoder;
    private final LoginInfoService loginInfoService;

    
@Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,LoginInfoService loginInfoService) {
        this.passwordEncoder = passwordEncoder;
        this.loginInfoService = loginInfoService;
     
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(),JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login", "/register","/loginToken","/logout", "/hello").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProviderOurs daoAuthenticationProvider() {
        DaoAuthenticationProviderOurs provider = new DaoAuthenticationProviderOurs();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        provider.setUserDetailsService(loginInfoService);
        return provider;
    }


    */
}