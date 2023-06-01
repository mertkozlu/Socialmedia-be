package com.socialmedia.SocialMedia.business;

import com.socialmedia.SocialMedia.dataAccess.UserRepository;
import com.socialmedia.SocialMedia.entitites.User;
import com.socialmedia.SocialMedia.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return JwtUserDetails.create(user);
    }
}
