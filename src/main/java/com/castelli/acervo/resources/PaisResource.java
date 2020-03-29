package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.services.PaisService;

@RestController
@RequestMapping(value="/paises")
public class PaisResource {
	
	@Autowired
	private PaisService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pais> find(@PathVariable Integer id) {
		Pais obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
