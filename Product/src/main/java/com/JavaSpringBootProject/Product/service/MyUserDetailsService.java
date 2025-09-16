package com.JavaSpringBootProject.Product.service;

import com.JavaSpringBootProject.Product.entity.User;
import com.JavaSpringBootProject.Product.repository.UserRepository;
import com.JavaSpringBootProject.Product.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
      return  userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isEmpty()) throw new UsernameNotFoundException("Username not found");
        return new UserPrincipal(byUsername.get());
    }
}
