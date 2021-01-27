package org.sid;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecuriteConfig extends WebSecurityConfigurerAdapter{
@Autowired

public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource)throws Exception{
//	PasswordEncoder passwordEncoder=passwordEncoder();
	//System.out.println("*************************");
	//System.out.println(passwordEncoder.encode("123"));
	//System.out.println("*************************");
	/*
	auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","PROF");
	auth.inMemoryAuthentication().withUser("prof1").password("{noop}123").roles("PROF");
	auth.inMemoryAuthentication().withUser("et1").password("{noop}123").roles("ETUDIANT");
	auth.inMemoryAuthentication().withUser("sco1").password("{noop}123").roles("SCOLARITE");

	*/
	
	auth.jdbcAuthentication()
		.dataSource(datasource)
	    .usersByUsernameQuery("select username as principal, password as credentials,true from users  where username = ?")
	    .authoritiesByUsernameQuery("select user_username as principal , roles_role as role from users_roles  where user_username = ?")
    .rolePrefix("ROLE_");
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
		    .authorizeRequests()
		    	.anyRequest()
		    		.authenticated()
						.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.defaultSuccessUrl("/index.html")
			.failureUrl("/error.html");
		    
					
						
	}
/*
@Bean(name="myPasswordEncoder")
public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder delPasswordEncoder=  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
    delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
    return delPasswordEncoder;      
}*/
@SuppressWarnings("deprecation")
@Bean
public static NoOpPasswordEncoder passwordEncoder() {
return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
}