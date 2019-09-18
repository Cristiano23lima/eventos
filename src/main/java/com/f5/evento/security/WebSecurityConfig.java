package com.f5.evento.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private ImplementsUserDetailsService IUDS;
	public WebSecurityConfig(ImplementsUserDetailsService iuds) {
		this.IUDS = iuds;
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/login").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.POST, "/addCliente").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/editCliente").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/deleteCliente/").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(IUDS)
	        .passwordEncoder(new BCryptPasswordEncoder());
	 }
	 
	 @Bean
	 @Override
	 protected AuthenticationManager authenticationManager() throws Exception{
		 return super.authenticationManager();
	 }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	 }
}
