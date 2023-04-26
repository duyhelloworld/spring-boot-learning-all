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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity(debug = true)

@EnableWebSecurity
public class SecurityConfig {
/**
 * Basic credentials : username+password to server by HTTP header
*/
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic();
        return http.build();
    }

/**
 * 
 */
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.authorizeHttpRequests(
    //         rq -> rq.requestMatchers(HttpMethod.GET, "/", "/**")
    //             .authenticated())
    //         .httpBasic();
    //     return http.build();
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .authorizeHttpRequests(requests ->
    // requests.requestMatchers("/", "/home")
    // // .hasAnyRole("USER", "ADMIN")
    // .permitAll())
    // .authorizeHttpRequests(request ->
    // request.requestMatchers("/admin/**", "/admin")
    // .hasRole("ADMIN"))
    // .authorizeHttpRequests(request ->
    // request.requestMatchers("/user/**", "/user")
    // .hasRole("USER"))
    // .logout(logout -> logout.permitAll())
    // .formLogin();
    // return http.build();
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usr1 = User.withUsername("joker")
                .password("{noop}joker")
                .roles("USER").build();

        UserDetails usr2 = User.withDefaultPasswordEncoder()
                .username("batman")
                .password("batman")
                .roles("USER").build();

        UserDetails adm = User.withUsername("superman")
                .password("{noop}superman")
                .roles("ADMIN")
                .build();
        // PasswordEncoder encoder =
        // PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // UserDetails usrEncoded =
        // User.withUsername("user2").password(encoder.encode("password")).build();
        // System.out.println(usrEncoded.getUsername() + "\t" +
        // usrEncoded.getPassword());

        System.out.println(
                "No encode : " + usr1.getUsername() + "\t" + usr1.getPassword() + "\nEnable : " + usr1.isEnabled());
        // return new InMemoryUserDetailsManager(usr1);
        System.out.println("Default encoder : " + usr2.getUsername() + "\t" + usr2.getPassword());
        System.out.println("Admin : " + adm.getUsername() + "\t" + adm.getPassword() + "\nEnable : " + adm.isEnabled());
        return new InMemoryUserDetailsManager(usr1, usr2, adm);
    }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
