package com.amoelcodigo.crud.service.impl;

import com.amoelcodigo.crud.dao.UsuarioDao;
import com.amoelcodigo.crud.entity.Usuario;
import com.amoelcodigo.crud.service.UsuarioService;
import com.amoelcodigo.crud.vo.UsuarioVo;
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
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	@Transactional
	public void save(UsuarioVo usuarioVo) {
		Integer id = usuarioVo.getId();
		Boolean objectAlreadyExists=usuarioDao.existsById(id);
		if(!objectAlreadyExists) {
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuarioVo, usuario);
			usuarioDao.save(usuario);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(UsuarioVo usuarioVo) {
		Integer id = usuarioVo.getId();
		Boolean objectExists=usuarioDao.existsById(id);
		if(objectExists) {
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuarioVo, usuario);
			usuarioDao.save(usuario);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=usuarioDao.existsById(id);
		if(objectExists) {
			usuarioDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public UsuarioVo get(Integer id) {
		Optional<Usuario> usuarioOptional = usuarioDao.findById(id);
		UsuarioVo usuarioVo=null;
		if(usuarioOptional.isPresent()) {
			usuarioVo = new UsuarioVo();
			BeanUtils.copyProperties(usuarioOptional.get(), usuarioVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return usuarioVo;
	}

	@Override
	@Transactional
	public List<UsuarioVo> getAll() {
		List<Usuario> usuarioList = usuarioDao.findAll();
		List<UsuarioVo> usuarioVoList = new ArrayList<>();
		if (usuarioList != null && !usuarioList.isEmpty()) {
			for (Usuario usuario : usuarioList) {
				UsuarioVo usuarioVo = new UsuarioVo();
				BeanUtils.copyProperties(usuario, usuarioVo);
				usuarioVoList.add(usuarioVo);
			}
		}
		return usuarioVoList;
	}

}

