package com.amoelcodigo.crud.service;

import com.amoelcodigo.crud.vo.UsuarioVo;


import java.util.List;

public interface UsuarioService {

	void save(UsuarioVo usuarioVo) ;
	void update(UsuarioVo usuarioVo) ;
	void delete(Integer id);
	UsuarioVo get(Integer id);
	List<UsuarioVo> getAll();

}

