package com.example.product_aggregator_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
//
//    public SecurityConfig(PasswordEncoder passwordEncoder, CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider) {
//        this.passwordEncoder = passwordEncoder;
//        this.customUsernamePasswordAuthenticationProvider = customUsernamePasswordAuthenticationProvider;
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/h2**"); // do not remove this line
        //TODO: If you are implementing the security requirements, remove this following line
//        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/home", true)
                .and()
                .logout()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }
}
