package fr.hiapoe.eccmserver.eccmserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${eccm.security.http.auth-token-header}")
    private String authTokenHeader;
    @Value("${eccm.security.http.auth-token}")
    private String authToken;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(this.authTokenHeader);
        filter.setAuthenticationManager(authentication -> {
            String principal = String.valueOf(authentication.getPrincipal());
            if (!authToken.equals(principal)) {
                throw new BadCredentialsException("The API key was not found or not the expected value");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });
        http
                .antMatcher("/api/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilter(filter).authorizeHttpRequests().anyRequest().authenticated();
    }
}
