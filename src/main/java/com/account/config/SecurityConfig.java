package com.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("Bekter").password("12345").roles("admin").and()
               .withUser("Amid").password("12345").roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.httpBasic().and().authorizeRequests().antMatchers().hasRole("")
               .antMatchers().hasRole("").and().csrf().disable().formLogin().disable();
    }
}
