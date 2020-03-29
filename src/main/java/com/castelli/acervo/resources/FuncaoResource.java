package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.services.FuncaoService;

@RestController
@RequestMapping(value="/funcoes")
public class FuncaoResource {
	
	@Autowired
	private FuncaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcao> find(@PathVariable Integer id) {
		Funcao obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
