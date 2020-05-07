package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.castelli.acervo.domain.Movimento;
import com.castelli.acervo.services.MovimentoService;

@RestController
@RequestMapping(value="/movimentos")
public class MovimentoResource {
	
	@Autowired
	private MovimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Movimento> find(@PathVariable Integer id) {
		Movimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
