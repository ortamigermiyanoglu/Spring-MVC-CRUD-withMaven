package com.sumutella.departmentcrud.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author sumutella
 * @time 10:14 AM
 * @since 11/14/2019, Thu
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication().withUser(
                users.username("sumutella").password("1234").roles("ADMIN")
        ). withUser(
                users.username("ortamigermiyanoglu").password("1234").roles("EMPLOYEE")
        ).withUser(
                users.username("theytookourjobs").password("1234").roles("MANAGER")
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and()
                .formLogin().loginPage("/my-login").loginProcessingUrl("/auth-user")
                .defaultSuccessUrl("/department/list-departments").permitAll();
    }



}
