package com.springboot.security.learning.oauth.security;

// import java.io.IOException;

// import org.springframework.http.HttpHeaders;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

public class JwtAuth {
    
}

// @Component
// public class JwtAuth extends OncePerRequestFilter {

//     private UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//         final String userEmail;
//         final String jsWebToken;

//         if (authHeader == null || !authHeader.startsWith("Bearer")) {
//             filterChain.doFilter(request, response);   
//             return; 
//         }
//         jsWebToken = authHeader.substring(7);
//         userEmail = "superman@gmail.com";
//         if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//             final boolean isValidToken = true; // TODO
//             if(isValidToken){
//                 UsernamePasswordAuthenticationToken authToken = 
//                 new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }