package com.amoelcodigo.crud.service.impl;

import com.amoelcodigo.crud.dao.PermisosDao;
import com.amoelcodigo.crud.entity.Permisos;
import com.amoelcodigo.crud.service.PermisosService;
import com.amoelcodigo.crud.vo.PermisosVo;

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
public class PermisosServiceImpl implements PermisosService {

	@Autowired
	PermisosDao permisosDao;

	@Override
	@Transactional
	public void save(PermisosVo permisosVo) {
		Integer id = permisosVo.getId();
		Boolean objectAlreadyExists=permisosDao.existsById(id);
		if(!objectAlreadyExists) {
			Permisos permisos = new Permisos();
			BeanUtils.copyProperties(permisosVo, permisos);
			permisosDao.save(permisos);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(PermisosVo permisosVo) {
		Integer id = permisosVo.getId();
		Boolean objectExists=permisosDao.existsById(id);
		if(objectExists) {
			Permisos permisos = new Permisos();
			BeanUtils.copyProperties(permisosVo, permisos);
			permisosDao.save(permisos);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=permisosDao.existsById(id);
		if(objectExists) {
			permisosDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public PermisosVo get(Integer id) {
		Optional<Permisos> permisosOptional = permisosDao.findById(id);
		PermisosVo permisosVo=null;
		if(permisosOptional.isPresent()) {
			permisosVo = new PermisosVo();
			BeanUtils.copyProperties(permisosOptional.get(), permisosVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return permisosVo;
	}

	@Override
	@Transactional
	public List<PermisosVo> getAll() {
		List<Permisos> permisosList = permisosDao.findAll();
		List<PermisosVo> permisosVoList = new ArrayList<>();
		if (permisosList != null && !permisosList.isEmpty()) {
			for (Permisos permisos : permisosList) {
				PermisosVo permisosVo = new PermisosVo();
				BeanUtils.copyProperties(permisos, permisosVo);
				permisosVoList.add(permisosVo);
			}
		}
		return permisosVoList;
	}

}

