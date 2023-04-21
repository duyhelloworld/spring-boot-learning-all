package com.springboot.security.learning.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity(debug = true)
@EnableWebSecurity
// Expose 2 bean below
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> 
                requests.requestMatchers("/", "/home")
                // .hasAnyRole("USER", "ADMIN")
                .permitAll())
            .authorizeHttpRequests(request -> 
                request.requestMatchers("/admin/**", "/admin")
                .hasRole("ADMIN"))
            .authorizeHttpRequests(request -> 
                request.requestMatchers("/user/**", "/user")
                .hasRole("USER"))
                .logout(logout -> logout.permitAll())
                .formLogin();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails usr = User.withDefaultPasswordEncoder()
        .username("batman")
        .password("batman")
        .roles("USER").build();

        UserDetails adm = User.withUsername("superman")
        .password("superman")
        .roles("ADMIN")
        .build();
        // UserDetails usrEncoded = User.withUsername("user2").password(encoder.encode("password")).build();
        // System.out.println(usrEncoded.getUsername() + "\t" + usrEncoded.getPassword());
        System.out.println(usr.getUsername() + "\t" + usr.getPassword() + "\nEnable : " + usr.isEnabled());
        System.out.println(adm.getUsername() + "\t" + adm.getPassword() + "\nEnable : " + adm.isEnabled());
        return new InMemoryUserDetailsManager(usr, adm);
    }
}
