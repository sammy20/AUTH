package fmi.pserasmusip.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static fmi.pserasmusip.security.SecurityConstants.HEADER_STRING;

public class JWTFilter extends GenericFilterBean {

    private UserDetailsService userDetailsService;
    private String authTokenHeaderName = "TOKEN";

    private TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationService();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
            throws IOException, ServletException {

        String header = ((HttpServletRequest)request).getHeader(HEADER_STRING);

        Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filter.doFilter(request, response);
    }
}
