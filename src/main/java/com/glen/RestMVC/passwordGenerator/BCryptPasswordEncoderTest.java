package com.glen.RestMVC.passwordGenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		/*
		System.out.println(bCryptPasswordEncoder.encode("m@123"));
		System.out.println(bCryptPasswordEncoder.encode("s@123"));
		
		*/
		
		System.out.println(bCryptPasswordEncoder.encode("pass"));
		System.out.println(bCryptPasswordEncoder.encode("pass"));
	}
	
}
