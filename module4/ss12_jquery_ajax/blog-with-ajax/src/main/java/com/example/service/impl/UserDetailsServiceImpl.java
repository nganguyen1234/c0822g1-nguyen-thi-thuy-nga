package com.example.service.impl;

import com.example.model.RoleUser;
import org.springframework.security.core.userdetails.User;
import com.example.repository.IRoleUserRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository appUserRepository;

    @Autowired
    private IRoleUserRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.example.model.User appUser = this.appUserRepository.findByUsername(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<RoleUser> userRoles = this.userRoleRepository.findByUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (RoleUser userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), //
                appUser.getPassword(), grantList);

        return userDetails;
    }
}
