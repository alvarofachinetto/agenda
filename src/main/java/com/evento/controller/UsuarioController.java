package com.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Usuario;
import com.evento.repository.UsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/templates/telas/usuario")
	public ModelAndView cadastroUsuario(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("/templates/telas/usuario");
		modelAndView.addObject("usuarioobj", usuario);
		
		return modelAndView;
	}
}
