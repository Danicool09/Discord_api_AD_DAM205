package com.amoelcodigo.crud.service.impl;

import com.amoelcodigo.crud.dao.ServidorDao;
import com.amoelcodigo.crud.entity.Servidor;
import com.amoelcodigo.crud.service.ServidorService;
import com.amoelcodigo.crud.vo.ServidorVo;

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
public class ServidorServiceImpl implements ServidorService {

	@Autowired
	ServidorDao servidorDao;

	@Override
	@Transactional
	public void save(ServidorVo servidorVo) {
		Integer id = servidorVo.getId();
		Boolean objectAlreadyExists=servidorDao.existsById(id);
		if(!objectAlreadyExists) {
			Servidor servidor = new Servidor();
			BeanUtils.copyProperties(servidorVo, servidor);
			servidorDao.save(servidor);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(ServidorVo servidorVo) {
		Integer id = servidorVo.getId();
		Boolean objectExists=servidorDao.existsById(id);
		if(objectExists) {
			Servidor servidor = new Servidor();
			BeanUtils.copyProperties(servidorVo, servidor);
			servidorDao.save(servidor);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=servidorDao.existsById(id);
		if(objectExists) {
			servidorDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public ServidorVo get(Integer id) {
		Optional<Servidor> servidorOptional = servidorDao.findById(id);
		ServidorVo servidorVo=null;
		if(servidorOptional.isPresent()) {
			servidorVo = new ServidorVo();
			BeanUtils.copyProperties(servidorOptional.get(), servidorVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return servidorVo;
	}

	@Override
	@Transactional
	public List<ServidorVo> getAll() {
		List<Servidor> servidorList = servidorDao.findAll();
		List<ServidorVo> servidorVoList = new ArrayList<>();
		if (servidorList != null && !servidorList.isEmpty()) {
			for (Servidor servidor : servidorList) {
				ServidorVo servidorVo = new ServidorVo();
				BeanUtils.copyProperties(servidor, servidorVo);
				servidorVoList.add(servidorVo);
			}
		}
		return servidorVoList;
	}

}

