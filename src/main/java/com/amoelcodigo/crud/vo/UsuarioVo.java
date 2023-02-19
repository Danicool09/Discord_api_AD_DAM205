package com.amoelcodigo.crud.vo;

public class UsuarioVo {

	private Integer id ;

	private String nickname ;

	private String mail ;

	private String nombre ;

	private String password ;

	private Integer perfilId ;

	private Integer servidores ;

	public UsuarioVo(){
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