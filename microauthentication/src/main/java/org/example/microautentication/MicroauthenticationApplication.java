package org.example.microautentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@SpringBootApplication
public class MicroauthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroauthenticationApplication.class, args);
    }


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


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .exceptionHandling(exceptions ->
                        exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")));

        return http.build();
    }




}
