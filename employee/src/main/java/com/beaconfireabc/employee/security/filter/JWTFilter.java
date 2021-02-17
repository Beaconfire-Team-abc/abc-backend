package com.beaconfireabc.employee.security.filter;

import com.beaconfireabc.employee.security.util.CookieUtil;
import com.beaconfireabc.employee.security.util.JWTUtil;
//import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

//@Component
public class JWTFilter extends OncePerRequestFilter {

    String signingKey = "signingKey";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        signingKey = Base64.getEncoder().encodeToString(signingKey.getBytes());
//        boolean validate = JWTUtil.isAuthenticated(httpServletRequest, "JWT-TOKEN", signingKey);
//        System.out.println("filter");
//
//        String resource = httpServletRequest.getRequestURI();
//        System.out.println(resource);
//
//        if (validate) {
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//        } else{
//            String authService = this.getFilterConfig().getInitParameter("services.auth");
//            httpServletResponse.sendRedirect(authService + "?redirect=" + resource);
//        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
