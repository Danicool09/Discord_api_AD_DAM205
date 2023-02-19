package com.amoelcodigo.crud.service;


import com.amoelcodigo.crud.vo.ServidorVo;

import java.util.List;

public interface ServidorService {

	void save(ServidorVo servidorVo) ;
	void update(ServidorVo servidorVo) ;
	void delete(Integer id);
	ServidorVo get(Integer id);
	List<ServidorVo> getAll();

}

