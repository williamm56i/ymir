package com.williamm56i.ymir.security;

import com.williamm56i.ymir.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class YmirUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String jwt) throws UsernameNotFoundException {
        String account = JwtUtils.parseJwt(jwt);
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return new YmirUserDetails(account, null, null);
    }

    public UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) ? (YmirUserDetails) authentication.getPrincipal() : null;
    }

    public String getUsername() {
        return getUserDetails().getUsername();
    }
}
