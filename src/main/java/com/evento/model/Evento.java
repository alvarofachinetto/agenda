package com.evento.model;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="evento")
@SuppressWarnings("deprecation")
public class Evento{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codEvento")
	private long codEvento;
	
	@Column(name="nomeEvento")
	private String nomeEvento;
	
	@Column(name="dataEvento")
	private SimpleDateFormat dataEvento; 

	@Column(name="pessoas")
	private String nomePessoas;
	
	@Column(name="descricaoEvento")
	private String descricaoEvento;
	
	@ForeignKey(name="codUsuario")
	@ManyToOne
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(long codEvento) {
		this.codEvento = codEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public SimpleDateFormat getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(SimpleDateFormat dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getNomePessoas() {
		return nomePessoas;
	}

	public void setNomePessoas(String nomePessoas) {
		this.nomePessoas = nomePessoas;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	
}
