package com.f5.evento.model;

import java.io.Serializable;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Usuarios Usuario;*/
	
	private String nome;
	private String email;
	/*public Usuarios getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.Usuario = usuario;
	}*/

	private String telefone;
	
	public Cliente() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
