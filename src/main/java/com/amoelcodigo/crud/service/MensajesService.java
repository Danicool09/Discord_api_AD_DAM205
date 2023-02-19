package com.amoelcodigo.crud.service;

import com.amoelcodigo.crud.vo.MensajesVo;


import java.util.List;

public interface MensajesService {

	void save(MensajesVo mensajesVo) ;
	void update(MensajesVo mensajesVo) ;
	void delete(Integer id);
	MensajesVo get(Integer id);
	List<MensajesVo> getAll();

}

