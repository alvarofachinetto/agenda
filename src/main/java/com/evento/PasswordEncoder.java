package com.evento;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//ele vai criptografar a senha
		System.out.println(passwordEncoder.encode("Alvaro"));
		
	}

}
