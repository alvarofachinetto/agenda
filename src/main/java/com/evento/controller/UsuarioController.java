package com.evento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Evento;
import com.evento.model.Usuario;
import com.evento.repository.EventoRepository;
import com.evento.repository.UsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EventoRepository eventoRepository;
	
	//carregar tela login
	@GetMapping("/login")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	//carrega tela de usuario
	@RequestMapping(method = RequestMethod.GET, value="/telas/usuario")
	public ModelAndView formCadastro() {
		ModelAndView modelAndView = new ModelAndView("/telas/usuario");
		modelAndView.addObject("usuarioobj", new Usuario());
		return modelAndView;
		
	}
	//cadastrar usuario
	@RequestMapping(method = RequestMethod.POST, value="**/cadastrarusuario")
	public ModelAndView cadastroUsuario(Usuario usuario) {
				
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("/telas/usuario");
		modelAndView.addObject("usuarioobj", new Usuario());
		
		return index(); //retorna o carregamento da tela login 
	}
	
	//carrega tela de evento
	@GetMapping("/telas/eventos/")
	public ModelAndView principalEventos() {
		ModelAndView modelAndView = new ModelAndView("/telas/evento");
		modelAndView.addObject("eventoobj", new Evento());
		
		return modelAndView;
	}
	
	//cadastrar evento
//		@PostMapping("**/addevevnto/{codusuario}")
//		public ModelAndView cadastroEvento(@Valid Evento evento, @PathVariable("codusuario")
//		Long codUsuario) {
//					
//			Usuario usuario = usuarioRepository.findById(codUsuario).get();
//			evento.setUsuario(usuario);
//			eventoRepository.save(evento);
//			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
//			modelAndView.addObject("usuarioobj", usuario);
//			modelAndView.addObject("eventos", eventoRepository.eventos(codUsuario));
//			
//			return modelAndView; 
//		}
	
	
	 
}
