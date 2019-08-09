package com.github.webisquid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthProvider authProvider;

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            // rest Login
            http.antMatcher("/secur/**").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic().and().csrf()
                    .disable();
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // form login
        http.authorizeRequests().antMatchers("/", "/login.xhtml", "/javax.faces.resource/**","/resources/**","/webjars/").permitAll().anyRequest()
                .fullyAuthenticated().and().formLogin().loginPage("/login.xhtml").defaultSuccessUrl("/index.xhtml")
                .failureUrl("/login.xhtml?authfailed=true").permitAll().and().logout().logoutSuccessUrl("/login.xhtml")
                .logoutUrl("/j_spring_security_logout").and().csrf().disable();

        // allow to use ressource links like pdf
        http.headers().frameOptions().sameOrigin();
    }


}
