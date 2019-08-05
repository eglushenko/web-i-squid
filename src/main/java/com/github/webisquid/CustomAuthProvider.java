package com.github.webisquid;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Here you can add a database connection for your custom login

        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (user.equalsIgnoreCase("user") && password.equalsIgnoreCase("user")){
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if (grantedAuths.size() > 0) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
            return auth;
        }

        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {

        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

    }

}
