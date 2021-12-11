package com.CSC280.Lab2Api.Controllers;

import com.CSC280.Lab2Api.Controllers.Repos.UserRepository;
import com.CSC280.Lab2Api.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;


@Configuration
@EnableWebSecurity
public class M2Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepo;

    static InMemoryUserDetailsManager memAuth = new InMemoryUserDetailsManager();

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("configure - A");
        
//        //
//        auth.inMemoryAuthentication().withUser("admin").password(passEncode()
//                .encode("pass")).roles("ADMIN")
//        .and().withUser("USER").password(passEncode().encode("pass")).roles("USER");
//        // */
        UserDetails newAdmin = User.withUsername("admin")
                .password(passEncode().encode("passWord"))
                .roles("ADMIN").build();
        memAuth.createUser(newAdmin);

        UserDetails newUser = User.withUsername("user")
                .password(passEncode().encode("passWord"))
                .roles("USER").build();
        memAuth.createUser(newUser);

        ArrayList<Users> userList = (ArrayList<Users>) userRepo.findAll();
        for(Users user : userList){
            UserDetails newUserAdd = User.withUsername(user.getUserName())
                    .password(passEncode().encode(user.getPassWord()))
                    .roles(user.getRolesList()).build();
            memAuth.createUser(newUserAdd);
        }

        auth.userDetailsService(memAuth);
    }
    // ///////////////////////////////////////////
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("configure - B");

        // 
//        http.authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
        
        http.cors().and().authorizeRequests()
        .antMatchers("/anyone/**").permitAll()
        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        .antMatchers("/admin/**").hasRole("ADMIN")
        .and()
        .httpBasic()
//        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf().disable();

      }
    // ///////////////////////////////////////////
    @Bean
    PasswordEncoder passEncode() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager(){
        System.out.println("*** Enter getInMemoryUserDetailsManager(");
        return memAuth;
    }
	
}
