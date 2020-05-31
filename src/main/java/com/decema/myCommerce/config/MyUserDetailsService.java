package com.decema.myCommerce.config;

import com.decema.myCommerce.model.MyUserDetails;
import com.decema.myCommerce.model.User;
import com.decema.myCommerce.repository.UserRepository;
import com.decema.myCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email).orElse(null));
        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + email);
        }
        else{
            return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
        }
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
//        return user.map(MyUserDetails::new).get();
    }

//    public User findByEmail(String email) {
//        return userService.getUserByEmail(email);
//    }
}
