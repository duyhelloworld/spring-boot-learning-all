package com.springboot.security.learning.oauth.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity(debug = true)

@EnableWebSecurity
public class SecurityConfig {
/**
 * On default 
 */
// @Bean
// @Order(SecurityProperties.BASIC_AUTH_ORDER)
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests()
//                 .anyRequest().authenticated()
//                 .and()
//                 .formLogin()
//                 .and()
//                 .httpBasic();
//         return http.build();
// }

/**
 * Basic credentials : username+password to server by HTTP header
*/
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // .authorizeHttpRequests(req -> req.requestMatchers("/").permitAll())
        .authorizeHttpRequests().requestMatchers("/", "/home", "/say-hello", "/say-goodbye").permitAll()  
                                                // Cho phép mọi người được access vô các URL này ko cần xác thực
        .anyRequest().authenticated()
                                                // Còn lại các /api, /admin ... thì cần xác thực
        .and()
        .formLogin()                           // Xác thực bằng formLogin mặc định trong srping security
        // .successForwardUrl("/admin/api/v1/hero")
        .successForwardUrl("/shop")
        .failureUrl("/login?error")
        // .permitAll()                            // Cho phép ai cũng truy cập được vào
        .and()
        .logout()                               // Cho phép logout
        .and()
        .httpBasic();                           // Xác thực username-password đơn giản (gửi trong HTTP header)
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usr1 = User
                .withUsername("flash")
                .password("{noop}flash")
                .roles("USER")
                .build();

        UserDetails usr2 = User
                .withDefaultPasswordEncoder()
                .username("batman1")
                .password("batman")
                .roles("USER").build();

        UserDetails adm = User
                .withUsername("superman")
                .password("{noop}superman")
                .roles("ADMIN")
                .build();
            
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails usr2_encoded = User.withUsername("batman2")
                .password(encoder.encode("batman"))
                .roles("USER")
                .build();
        
        System.out.println("Use Encoder" + usr2_encoded.getUsername() 
                                + "\t" + usr2_encoded.getPassword());

        System.out.println("No encode : " + usr1.getUsername()
                                + "\t" + usr1.getPassword());
        // return new InMemoryUserDetailsManager(usr1);
        System.out.println("Default encoder : " + usr2.getUsername() 
                                + "\t" + usr2.getPassword());
        System.out.println("Admin : " + adm.getUsername() 
                                + "\t" + adm.getPassword() 
                                + "\nEnable : " + adm.isEnabled());
        return new InMemoryUserDetailsManager(usr1, usr2, usr2_encoded, adm);
    }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
