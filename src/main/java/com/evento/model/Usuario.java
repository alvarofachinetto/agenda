package com.evento.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario() {
		eventos = new TreeSet<Evento>();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="codUsuario")
	private long codUsuario;
	
	@NotEmpty(message="Email não pode ser vazio")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="Nome não pode ser vazio")
	@Column(name="nome")
	private String nome;
	
	
	@NotNull(message="Idade não pode ser nula")
	@Column(name="idade")
	private int idade;

	@OneToMany(mappedBy="usuario", orphanRemoval= true, cascade= CascadeType.ALL)
	private Set <Evento> eventos;
	
	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos.clear();
		this.eventos.addAll(eventos);
	}

	public long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}
