package com.amoelcodigo.crud.service;

import com.amoelcodigo.crud.vo.PerfilVo;


import java.util.List;

public interface PerfilService {

	void save(PerfilVo perfilVo) ;
	void update(PerfilVo perfilVo) ;
	void delete(Integer id);
	PerfilVo get(Integer id);
	List<PerfilVo> getAll();

}

