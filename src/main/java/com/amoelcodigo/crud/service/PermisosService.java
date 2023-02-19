package com.amoelcodigo.crud.service;

import com.amoelcodigo.crud.vo.PermisosVo;


import java.util.List;

public interface PermisosService {

	void save(PermisosVo permisosVo) ;
	void update(PermisosVo permisosVo) ;
	void delete(Integer id);
	PermisosVo get(Integer id);
	List<PermisosVo> getAll();

}

