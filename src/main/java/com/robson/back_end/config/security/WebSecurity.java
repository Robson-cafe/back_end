//package com.robson.back_end.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class WebSecurity extends WebSecurityConfigurerAdapter {
 //   @Autowired
 //   AuthenticatorService authenticatorService;
//
  //  @Override
  //  protected void configure(HttpSecurity http) throws Exception {
        //System.out.println("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        //http.formLogin(); cria login padrão spring
  //      http.httpBasic();
   //     http.authorizeHttpRequests()
   //             .antMatchers(HttpMethod.DELETE, "/clients/**").hasRole("ADMIN")
   //             .anyRequest().authenticated();
    //    http.csrf().disable();
   // }
//
   // @Override
  //  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //      /*auth
  //          .inMemoryAuthentication()
  //          .withUser("robson")
   //         .password("robson")
   //         .roles("ADMIN");
//
   //     auth
   //         .inMemoryAuthentication()
   //         .withUser("saulo")
    //        .password("123")
   //         .roles("USER");*/
   //     auth
  //             .userDetailsService(authenticatorService)
  //              .passwordEncoder(passwordEncoder());
   // }
//
   // @Bean
 //   public PasswordEncoder passwordEncoder() {
  //      return new BCryptPasswordEncoder();
  //  }
//}
//