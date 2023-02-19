package com.amoelcodigo.crud.service.impl;

import com.amoelcodigo.crud.dao.MensajesDao;
import com.amoelcodigo.crud.entity.Mensajes;
import com.amoelcodigo.crud.service.MensajesService;
import com.amoelcodigo.crud.vo.MensajesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MensajesServiceImpl implements MensajesService {

	@Autowired
	MensajesDao mensajesDao;

	@Override
	@Transactional
	public void save(MensajesVo mensajesVo) {
		Integer id = mensajesVo.getId();
		Boolean objectAlreadyExists=mensajesDao.existsById(id);
		if(!objectAlreadyExists) {
			Mensajes mensajes = new Mensajes();
			BeanUtils.copyProperties(mensajesVo, mensajes);
			mensajesDao.save(mensajes);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(MensajesVo mensajesVo) {
		Integer id = mensajesVo.getId();
		Boolean objectExists=mensajesDao.existsById(id);
		if(objectExists) {
			Mensajes mensajes = new Mensajes();
			BeanUtils.copyProperties(mensajesVo, mensajes);
			mensajesDao.save(mensajes);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=mensajesDao.existsById(id);
		if(objectExists) {
			mensajesDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public MensajesVo get(Integer id) {
		Optional<Mensajes> mensajesOptional = mensajesDao.findById(id);
		MensajesVo mensajesVo=null;
		if(mensajesOptional.isPresent()) {
			mensajesVo = new MensajesVo();
			BeanUtils.copyProperties(mensajesOptional.get(), mensajesVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return mensajesVo;
	}

	@Override
	@Transactional
	public List<MensajesVo> getAll() {
		List<Mensajes> mensajesList = mensajesDao.findAll();
		List<MensajesVo> mensajesVoList = new ArrayList<>();
		if (mensajesList != null && !mensajesList.isEmpty()) {
			for (Mensajes mensajes : mensajesList) {
				MensajesVo mensajesVo = new MensajesVo();
				BeanUtils.copyProperties(mensajes, mensajesVo);
				mensajesVoList.add(mensajesVo);
			}
		}
		return mensajesVoList;
	}

}

