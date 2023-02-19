package com.amoelcodigo.crud.controller;

import com.amoelcodigo.crud.service.PerfilService;
import com.amoelcodigo.crud.vo.PerfilVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@PostMapping("perfil")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(PerfilVo perfilVo) {
		perfilService.save(perfilVo);
	}

	@GetMapping("perfil/{id}")
	public PerfilVo get( @PathVariable Integer id) {
		return perfilService.get(id);
	}

	@GetMapping("perfil")
	public List<PerfilVo>  getAll() {
		return perfilService.getAll();
	}
	
	@PutMapping("perfil/{id}")
	public void update(PerfilVo perfilVo) {
		perfilService.update(perfilVo);
	}
	
	@DeleteMapping("perfil/{id}")
	public void delete( @PathVariable Integer id) {
		perfilService.delete(id);
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
