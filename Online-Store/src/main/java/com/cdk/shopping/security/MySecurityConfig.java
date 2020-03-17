/**
 * 
 */

package com.cdk.shopping.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author sudhirk
 *
 */
@SuppressWarnings("deprecation")

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance
	 * ()).withUser("user")
	 * .password("123").roles("user").and().withUser("admin1").password("123").roles
	 * ("user", "admin"); }
	 */

	// For authentication using h2-DB

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests().
		antMatchers("/register/**").permitAll()
		.antMatchers("/confirm").permitAll()
		.antMatchers("/h2/**").permitAll()
		.anyRequest().authenticated()//all other urls can be access by any authenticated role
        .and()
        .formLogin()//enable form login instead of basic login
		.and()
		.csrf().disable().headers().frameOptions().disable();
	}
}
