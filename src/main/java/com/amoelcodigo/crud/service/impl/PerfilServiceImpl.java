package com.amoelcodigo.crud.service.impl;

import com.amoelcodigo.crud.dao.PerfilDao;
import com.amoelcodigo.crud.entity.Perfil;
import com.amoelcodigo.crud.service.PerfilService;
import com.amoelcodigo.crud.vo.PerfilVo;

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
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	PerfilDao perfilDao;

	@Override
	@Transactional
	public void save(PerfilVo perfilVo) {
		Integer id = perfilVo.getId();
		Boolean objectAlreadyExists=perfilDao.existsById(id);
		if(!objectAlreadyExists) {
			Perfil perfil = new Perfil();
			BeanUtils.copyProperties(perfilVo, perfil);
			perfilDao.save(perfil);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(PerfilVo perfilVo) {
		Integer id = perfilVo.getId();
		Boolean objectExists=perfilDao.existsById(id);
		if(objectExists) {
			Perfil perfil = new Perfil();
			BeanUtils.copyProperties(perfilVo, perfil);
			perfilDao.save(perfil);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=perfilDao.existsById(id);
		if(objectExists) {
			perfilDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public PerfilVo get(Integer id) {
		Optional<Perfil> perfilOptional = perfilDao.findById(id);
		PerfilVo perfilVo=null;
		if(perfilOptional.isPresent()) {
			perfilVo = new PerfilVo();
			BeanUtils.copyProperties(perfilOptional.get(), perfilVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return perfilVo;
	}

	@Override
	@Transactional
	public List<PerfilVo> getAll() {
		List<Perfil> perfilList = perfilDao.findAll();
		List<PerfilVo> perfilVoList = new ArrayList<>();
		if (perfilList != null && !perfilList.isEmpty()) {
			for (Perfil perfil : perfilList) {
				PerfilVo perfilVo = new PerfilVo();
				BeanUtils.copyProperties(perfil, perfilVo);
				perfilVoList.add(perfilVo);
			}
		}
		return perfilVoList;
	}

}

