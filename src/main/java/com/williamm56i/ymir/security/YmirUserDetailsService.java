package com.williamm56i.ymir.security;

import com.williamm56i.ymir.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class YmirUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String jwt) throws UsernameNotFoundException {
        return JwtUtils.parseJwt(jwt);
    }

    private UserDetails decode(String jwt) {
        String account = jwt;
        String password = "123";
        return new YmirUserDetails(account, password, null);
    }

    public UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) ? (YmirUserDetails) authentication.getPrincipal() : null;
    }

    public String getUsername() {
        return getUserDetails().getUsername();
    }
}
