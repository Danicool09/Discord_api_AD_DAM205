package com.amoelcodigo.crud.vo;

public class MensajesVo {

	private Integer id ;

	private String mensaje ;

	private Integer usuarioId ;

	public MensajesVo(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getMensaje(){
		return this.mensaje;
	}

	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}

	public Integer getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this.usuarioId = usuarioId;
	}

}