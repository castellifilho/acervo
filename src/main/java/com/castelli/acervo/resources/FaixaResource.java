package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.castelli.acervo.domain.Faixa;
import com.castelli.acervo.services.FaixaService;

@RestController
@RequestMapping(value="/faixas")
public class FaixaResource {
	
	@Autowired
	private FaixaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Faixa> find(@PathVariable Integer id) {
		Faixa obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
}
