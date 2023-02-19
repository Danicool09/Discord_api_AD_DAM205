package com.amoelcodigo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="nickname")
	private String nickname ;

	@Column(name="mail")
	private String mail ;

	@Column(name="nombre")
	private String nombre ;

	@Column(name="password")
	private String password ;

	@Column(name="perfil_id")
	private Integer perfilId ;

	@Column(name="servidores")
	private Integer servidores ;

	public Usuario(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNickname(){
		return this.nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getMail(){
		return this.mail;
	}

	public void setMail(String mail){
		this.mail = mail;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Integer getPerfilId(){
		return this.perfilId;
	}

	public void setPerfilId(Integer perfilId){
		this.perfilId = perfilId;
	}

	public Integer getServidores(){
		return this.servidores;
	}

	public void setServidores(Integer servidores){
		this.servidores = servidores;
	}

}