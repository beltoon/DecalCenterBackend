package com.tobias.decalcenter.config;

import com.tobias.decalcenter.filter.JwtRequestFilter;

import com.tobias.decalcenter.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled "
                        + "FROM users "
                        + "WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authority "
                        + "FROM authorities "
                        + "WHERE username=?");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( "/authenticate/**").permitAll()
                .antMatchers(HttpMethod.GET, "/decals").permitAll()
                .antMatchers(HttpMethod.GET, "/users/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/upload").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/decals/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/authenticated").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}