package com.evento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
		modelAndView.addObject("logarobj", new Usuario());
		return modelAndView;
	}
	
	//carrega tela de usuario e lista 
	@RequestMapping(method = RequestMethod.GET, value="/telas/usuario")
	public ModelAndView formCadastro() {
		try {
			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
			modelAndView.addObject("usuarioobj", new Usuario());
			Iterable<Usuario> usuarioIt = usuarioRepository.findAll();
			modelAndView.addObject("usuarios", usuarioIt);
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		
	}
	//cadastrar e validar usuario
	@RequestMapping(method = RequestMethod.POST, value="**/cadastrarusuario")
	public ModelAndView cadastroUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		try {
			if(bindingResult.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView("/telas/usuario");
				System.out.println(modelAndView);
				Iterable<Usuario> usuarioIt = usuarioRepository.findAll();
				modelAndView.addObject("usuarios", usuarioIt);
				modelAndView.addObject("usuarioobj", usuario);
				
				List<String> msg = new ArrayList<String>();
				for(ObjectError erro : bindingResult.getAllErrors()) {
					msg.add(erro.getDefaultMessage());
				}
				
				modelAndView.addObject("msg", msg);
				return modelAndView;
			}
			
			usuarioRepository.save(usuario);
			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
			Iterable<Usuario> usuarioIt = usuarioRepository.findAll();
			modelAndView.addObject("usuarios", usuarioIt);
			modelAndView.addObject("usuarioobj", new Usuario());
			
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		
	}
	
	//listar Usuario
	@GetMapping("/listarusuario")
	public ModelAndView listarUsuario() {
		try {

			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
			Iterable<Usuario> usuarioIt = usuarioRepository.findAll();
			modelAndView.addObject("usuarios", usuarioIt);
			modelAndView.addObject("usuarioobj", new Usuario());
			
			return modelAndView;
			
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		
	}
	
	//editar usuario
	@GetMapping("/editarusuario/{codUsuario}")
	public ModelAndView editarUsuario(@PathVariable("codUsuario")Long codUsuario) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(codUsuario);
			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
			modelAndView.addObject("usuarioobj", usuario.get());
			
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		
	}
	
	//deletar usuario
	@GetMapping("/removerusuario/{codUsuario}")
	public ModelAndView removerUsuario(@PathVariable("codUsuario")Long codUsuario) {
		try {
			usuarioRepository.deleteById(codUsuario);
			ModelAndView modelAndView = new ModelAndView("/telas/usuario");
			modelAndView.addObject("usuarioobj", usuarioRepository.findAll());
			modelAndView.addObject("usuarioobj", new Usuario());
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}
	
	//carrega tela de evento
		@GetMapping("**/evento/{codUsuario}")
		public ModelAndView principalEventos(@PathVariable("codUsuario") Long codUsuario) {
			try {
				Optional<Usuario> usuario = usuarioRepository.findById(codUsuario);
				
				ModelAndView modelAndView = new ModelAndView("/telas/evento");
				modelAndView.addObject("usuarioobj", usuario.get());
				modelAndView.addObject("eventos", eventoRepository.eventos(codUsuario));
				return modelAndView;
			} catch (Exception e) {
				e.getMessage();
				throw e;
			}
			
		}
		
		//cadastrar evento
		@PostMapping("**/addEvento/{codUsuario}")
		public ModelAndView cadastroEvento(@Valid Evento evento, @PathVariable("codUsuario") Long codUsuario) {
			
			try {
				Usuario usuario = usuarioRepository.findById(codUsuario).get();
				evento.setUsuario(usuario);
				eventoRepository.save(evento);
				ModelAndView modelAndView = new ModelAndView("/telas/evento");
				modelAndView.addObject("usuarioobj", usuario);
				modelAndView.addObject("eventos", eventoRepository.eventos(codUsuario));
				return modelAndView;
			} catch (Exception e) {
				e.getMessage();
				throw e;
			}
			 
		}
		
		@GetMapping("**/editarEvento/{codEvento}")
		public ModelAndView editarEvento(@Valid Evento evento, @PathVariable("codEvento") Long codEvento) {
			
			try {
				
				Usuario usuario = eventoRepository.findById(codEvento).get().getUsuario(); 
				ModelAndView modelAndView = new ModelAndView("/telas/evento");
				modelAndView.addObject("usuarioobj", usuario);
				modelAndView.addObject("eventos", eventoRepository.eventos(usuario.getCodUsuario()));
				return modelAndView;
			} catch (Exception e) {
				e.getMessage();
				throw e;
			}
			 
		}
		
		@GetMapping("**/removerEvento/{codEvento}")
		public ModelAndView excluirEvento(@Valid Evento evento, @PathVariable("codEvento") Long codEvento) {
			
			try {
				
				Usuario usuario = eventoRepository.findById(codEvento).get().getUsuario();
				eventoRepository.deleteById(codEvento);
				
				ModelAndView modelAndView = new ModelAndView("/telas/evento");
				modelAndView.addObject("usuarioobj", usuario);
				modelAndView.addObject("eventos", eventoRepository.eventos(usuario.getCodUsuario()));
				return modelAndView;
			} catch (Exception e) {
				e.getMessage();
				throw e;
			}
			 
		}
	
}
