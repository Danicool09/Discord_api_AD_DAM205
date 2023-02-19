package com.amoelcodigo.crud.controller;

import com.amoelcodigo.crud.service.MensajesService;
import com.amoelcodigo.crud.vo.MensajesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class  MensajesController {

	@Autowired
	MensajesService mensajesService;

	@PostMapping("mensajes")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(MensajesVo mensajesVo) {
		mensajesService.save(mensajesVo);
	}

	@GetMapping("mensajes/{id}")
	public MensajesVo get( @PathVariable Integer id) {
		return mensajesService.get(id);
	}

	@GetMapping("mensajes")
	public List<MensajesVo>  getAll() {
		return mensajesService.getAll();
	}
	
	@PutMapping("mensajes")
	public void update(MensajesVo mensajesVo) {
		mensajesService.update(mensajesVo);
	}
	
	@DeleteMapping("mensajes/{id}")
	public void delete( @PathVariable Integer id) {
		mensajesService.delete(id);
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
