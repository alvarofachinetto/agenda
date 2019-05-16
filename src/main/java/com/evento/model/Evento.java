package com.evento.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codEvento")
	private long codEvento;
	
	@Column(name="nomeEvento")
	private String nomeEvento;
	
	@Column(name="dataEvento")
	private Date dataEvento; 

	@Column(name="pessoas")
	private String nomePessoas;
	
	@Column(name="descricaoEvento")
	private String descricaoEvento;
	
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

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
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
