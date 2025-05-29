package org.example.microautentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
    /**
     * Setups demo users
     * @param encoder
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        UserDetails user1 = User.builder()
                .username("user1")
                .password(encoder.encode("password"))
                .roles("JOKE", "QUOTE")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password(encoder.encode("password"))
                .roles("JOKE")
                .build();


        UserDetails user3 = User.builder()
                .username("user3")
                .password(encoder.encode("password"))
                .roles("QUOTE")
                .build();

        UserDetails user4 = User.builder()
                .username("user4")
                .password(encoder.encode("password"))
                .roles()
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
