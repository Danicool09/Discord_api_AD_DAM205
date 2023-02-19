package com.amoelcodigo.crud.controller;

import com.amoelcodigo.crud.service.PermisosService;
import com.amoelcodigo.crud.vo.PermisosVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PermisosController {

	@Autowired
	PermisosService permisosService;

	@PostMapping("permisos")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(PermisosVo permisosVo) {
		permisosService.save(permisosVo);
	}

	@GetMapping("permisos/{id}")
	public PermisosVo get( @PathVariable Integer id) {
		return permisosService.get(id);
	}

	@GetMapping("permisos")
	public List<PermisosVo>  getAll() {
		return permisosService.getAll();
	}
	
	@PutMapping("permisos{id}")
	public void update(PermisosVo permisosVo) {
		permisosService.update(permisosVo);
	}
	
	@DeleteMapping("permisos/{id}")
	public void delete( @PathVariable Integer id) {
		permisosService.delete(id);
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
