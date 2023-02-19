package com.amoelcodigo.crud.controller;

import com.amoelcodigo.crud.service.UsuarioService;
import com.amoelcodigo.crud.vo.UsuarioVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("usuario")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(UsuarioVo usuarioVo) {
		usuarioService.save(usuarioVo);
	}

	@GetMapping("usuario/{id}")
	public UsuarioVo get( @PathVariable Integer id) {
		return usuarioService.get(id);
	}

	@GetMapping("usuario")
	public List<UsuarioVo>  getAll() {
		return usuarioService.getAll();
	}
	
	@PutMapping("usuario/{id}")
	public void update(UsuarioVo usuarioVo) {
		usuarioService.update(usuarioVo);
	}
	
	@DeleteMapping("usuario/{id}")
	public void delete( @PathVariable Integer id) {
		usuarioService.delete(id);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleEntityExistsException(EntityExistsException e) {
	    return e.getMessage();
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
	    return e.getMessage();
	}
}
