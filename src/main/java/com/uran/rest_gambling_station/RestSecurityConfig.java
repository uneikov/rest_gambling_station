package com.uran.rest_gambling_station;

import com.uran.rest_gambling_station.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
                //.antMatchers("/webjars/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // for REST clients
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "STATION")
                .antMatchers("/profile/**").hasAnyRole("ADMIN", "USER")
                .regexMatchers("/horses/?[0-9]*").hasRole("ADMIN")
                .regexMatchers("/horses/names").hasAnyRole("ADMIN", "USER")
                .antMatchers("/stakes").hasAnyRole("ADMIN", "USER")
                .antMatchers("/races").access("hasRole('ADMIN') and hasRole('USER')")
                .anyRequest().authenticated()
                .and()
                .httpBasic() // basic auth
                .and()
                .sessionManagement().maximumSessions(1); // max concurrent session = 1
    }
}
