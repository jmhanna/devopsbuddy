package com.devopsbuddy.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by j_mha on 3/16/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private org.springframework.core.env.Environment env;


    private static final String[] PUBLIC_MATCHES ={
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if(activeProfiles.contains("dev")){
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }

        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHES).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password")
                .roles("USER");
    }
}
