package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().withUser("shubham.joshi@metacube.com")
				.password("{noop}lnm@#2016").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee@metacube.com")
				.password("{noop}lnm@#2016").roles("EMPLOYEE");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('EMPLOYEE')")
				.and()
				.formLogin()
				. // login configuration
				loginPage("/login").loginProcessingUrl("/Login")
				.defaultSuccessUrl("/default").usernameParameter("email")
				.passwordParameter("password").and().logout()
				.logoutUrl("/appLogout")
				// logout configuration
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/error").and().csrf();

	}
}
