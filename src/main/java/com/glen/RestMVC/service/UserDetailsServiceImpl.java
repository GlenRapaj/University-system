package com.glen.RestMVC.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.glen.RestMVC.model.Perdorues;
import com.glen.RestMVC.repository.PerdoruesRepo;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	PerdoruesRepo perdoruesRepo;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		short a =1;
		Perdorues perdorues = perdoruesRepo.findPerdoruesByEmailEnabled(username, a);
		// System.out.println(perdorues);
		
		
		if(perdorues.getId() != 0) {
			
			GrantedAuthority authority = new SimpleGrantedAuthority(perdorues.getRole() );
			
			
			System.out.println(authority);
			User user = new User(perdorues.getEmail(),perdorues.getPasword(),Arrays.asList(authority));
		
			System.out.println(user);
			
			UserDetails userDetails = (UserDetails) user;
		
			System.out.println(userDetails);
			
			return userDetails;
		}
		else {
			
			throw new UsernameNotFoundException(" perdoruesi nuk u gjet ");
		}
		
		
		
		/*
		  {
		return  User .builder()
		  .username(username)
		  .password("")
		  .roles("","")
		  .build;
		 }
		  
		 * */
		
	
	}
	
	
	

public void regjistroPerdoruesin( Perdorues regjistroPerdoruesin) {
	
	regjistroPerdoruesin.setPasword(bCryptPasswordEncoder.encode(regjistroPerdoruesin.getPasword()));
	perdoruesRepo.save( regjistroPerdoruesin);
}


}
