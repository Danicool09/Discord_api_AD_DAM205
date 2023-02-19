package com.amoelcodigo.crud.vo;

public class PerfilVo {

	private Integer id ;

	private String nickname ;

	private String banner ;

	private Integer usuarioId ;

	public PerfilVo(){
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