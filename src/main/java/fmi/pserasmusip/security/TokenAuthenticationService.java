package fmi.pserasmusip.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static fmi.pserasmusip.security.SecurityConstants.HEADER_STRING;
import static fmi.pserasmusip.security.SecurityConstants.SECRET;
import static fmi.pserasmusip.security.SecurityConstants.TOKEN_PREFIX;

@Service
public class TokenAuthenticationService {

    @Autowired
    private UserDetailsService userDetailsService;

    public Authentication getAuthentication(HttpServletRequest request) {
        Authentication authentication = null;

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            UserDetails userDetails = userDetailsService.loadUserByUsername(user);

            if (user != null) {
                authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                return authentication;
            }
            return null;
        }
        return null;
    }
}
