package com.bank.service.impl;

import com.bank.entity.User;
import com.bank.entity.common.UserPrincipal;
import com.bank.repository.UserRepository;
import com.bank.service.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //we need to get our own user from database
        User user = userRepository.findByUsername(username);
        //return some exception if user doesnt exist
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //return user information in as a UserDetails

        return new UserPrincipal(user);
    }
}
