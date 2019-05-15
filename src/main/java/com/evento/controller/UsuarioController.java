package com.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Usuario;
import com.evento.repository.UsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public ModelAndView index(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/telas/usuario")
	public ModelAndView formCadastro() {
		ModelAndView modelAndView = new ModelAndView("/telas/usuario");
		modelAndView.addObject("usuarioobj", new Usuario());
		return modelAndView;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="**/cadastrarusuario")
	public ModelAndView cadastroUsuario(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("/telas/usuario");
		modelAndView.addObject("usuarioobj", new Usuario());
		
		return modelAndView;
	}
	
	 
}
