package com.glen.RestMVC.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.glen.RestMVC.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private TopicAuthenticationEntryPoint topicAuthenticationEntryPoint;
	

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//super.configure(web);
		
		web
		.ignoring().antMatchers("/resources/**");
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//super.configure(http);
		
		http.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/student/**").permitAll()
		
		.antMatchers("/student/home").hasAnyRole("ADMIN")
		.antMatchers("/Control/**").hasAnyRole("ADMIN")
		.antMatchers("/student/sitem/regjistrosistem").permitAll()
		
		.antMatchers("/student/regjistro").hasAnyRole("USER","ADMIN")
		.antMatchers("/student/grupi/**").hasAnyRole("USER")
		.antMatchers("/student/fillimistd/**").hasAnyRole("USER")
		.antMatchers("/student/mesatarestdent/**").hasAnyRole("USER")
		.antMatchers("/student/").hasAnyRole("ADMIN","USER")
		.antMatchers("/student/data/**","/student/abaut").hasAnyRole("ADMIN","USER")
		.antMatchers( "/student/**").hasAnyRole("ADMIN")
		
		
		
		
		
		//.antMatchers("/student").permitAll()
		//.antMatchers("/student/login").permitAll()
		.antMatchers("/login").permitAll()
		.and()
		.formLogin()
		//.loginPage("/log")             USER
		 // .usernameParameter("email")
		 //  .passwordParameter("password")
        //.permitAll()
      .and()
       .logout().permitAll()
		
		.and().httpBasic().realmName("Topic security application Realm")
		.authenticationEntryPoint(topicAuthenticationEntryPoint);
		   
		
		   //.antMatchers("/**").hasAnyRole("ADMIN");
	}
	
	
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// super.configure(auth);
		BCryptPasswordEncoder psc = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(psc);
	}
	
	
	

	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	  return bCryptPasswordEncoder;
	 }
	
}
