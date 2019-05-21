package com.evento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.evento.model.Usuario;
import com.evento.repository.UsuarioRepository;

//@Component
//public class CustomUserDetailService implements UserDetailsService{

	//private final UsuarioRepository usuarioRepository;
	
//	@Autowired
//	public public CustomUserDetailService(UsuarioRepository usuarioRepository) {
//		this.usuarioRepository = usuarioRepository;
//	}
	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Usuario usuario = Optional.ofNullable(usuarioRepository.findByName(email)).orElseThrow(() -> new UsernameNotFoundException("Email not found"));//lança excecão se não encontrar um usuario
//		AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
//		return new User(usuario.getEmail(), usuario.getSenha());//colocar authorities
//	}

//}
