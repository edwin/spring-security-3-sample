package com.edw.service;

import com.edw.model.Admin;
import com.edw.model.User;
import com.edw.repository.AdminRepository;
import com.edw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *     com.edw.service.UserDetailService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Apr 2023 16:06
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // login as user
        User user = userRepository.findByUsername(username);
        if(user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswd(),
                    grantedAuthorities);
        }

        // login as admin
        Admin admin = adminRepository.findByUsername(username);
        if(admin != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

            return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPasswd(),
                    grantedAuthorities);
        }

        // username not found
        throw new UsernameNotFoundException("Username or Password is not found");
    }
}
