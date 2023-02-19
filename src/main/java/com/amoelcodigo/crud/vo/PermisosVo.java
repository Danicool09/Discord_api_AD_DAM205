package com.amoelcodigo.crud.vo;

public class PermisosVo {

	private Integer id ;

	private String nombre ;

	private String admin ;

	private Integer usuarioId ;

	public PermisosVo(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getAdmin(){
		return this.admin;
	}

	public void setAdmin(String admin){
		this.admin = admin;
	}

	public Integer getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this.usuarioId = usuarioId;
	}

}