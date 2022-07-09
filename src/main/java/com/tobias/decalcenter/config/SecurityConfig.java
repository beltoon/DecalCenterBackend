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

        //JWT token authentication
        http
//                .httpBasic()
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users/**").permitAll()
                .antMatchers(HttpMethod.GET, "/events/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/cars/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ADMIN", "USER")
//                .antMatchers(HttpMethod.GET, "/users").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/users").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.POST,"/users/*").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/cars/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/events/**").hasAuthority("ADMIN")
                .antMatchers("/authenticated").authenticated()
                .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}