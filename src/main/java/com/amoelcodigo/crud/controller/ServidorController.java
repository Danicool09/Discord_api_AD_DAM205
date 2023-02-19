package com.amoelcodigo.crud.controller;


import com.amoelcodigo.crud.service.ServidorService;
import com.amoelcodigo.crud.vo.ServidorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ServidorController {

	@Autowired
	ServidorService servidorService;

	@PostMapping("servidor")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(ServidorVo servidorVo) {
		servidorService.save(servidorVo);
	}

	@GetMapping("servidor/{id}")
	public ServidorVo get( @PathVariable Integer id) {
		return servidorService.get(id);
	}

	@GetMapping("servidor")
	public List<ServidorVo>  getAll() {
		return servidorService.getAll();
	}
	
	@PutMapping("servidor{id}")
	public void update(ServidorVo servidorVo) {
		servidorService.update(servidorVo);
	}
	
	@DeleteMapping("servidor/{id}")
	public void delete( @PathVariable Integer id) {
		servidorService.delete(id);
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
