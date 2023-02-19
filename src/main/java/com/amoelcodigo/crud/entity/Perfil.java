package com.amoelcodigo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Perfil")
public class Perfil {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="nickname")
	private String nickname ;

	@Column(name="banner")
	private String banner ;

	@Column(name="usuario_id")
	private Integer usuarioId ;

	public Perfil(){
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

	public String getBanner(){
		return this.banner;
	}

	public void setBanner(String banner){
		this.banner = banner;
	}

	public Integer getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this.usuarioId = usuarioId;
	}

}