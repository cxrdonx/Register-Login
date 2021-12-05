package com.Application.FoodTracker.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // no usamos constructor de appoUser repository por este implemento lombok
public class AppUserService  implements UserDetailsService {


        private final static String USER_NOT_FOUND = "user with email %s not found";
        private AppUserRepository appUserRepository;

        @Override
        public UserDetails loadUserByUsername (String str) throws UsernameNotFoundException {
            return appUserRepository.findByEmail(str).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, str)));
        }
}
