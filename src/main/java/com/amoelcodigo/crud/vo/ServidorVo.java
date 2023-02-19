package com.amoelcodigo.crud.vo;

public class ServidorVo {

	private Integer id ;

	private String nombre ;

	private String foto ;

	private String usuarioId ;

	public ServidorVo(){
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

	public String getFoto(){
		return this.foto;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId){
		this.usuarioId = usuarioId;
	}

}