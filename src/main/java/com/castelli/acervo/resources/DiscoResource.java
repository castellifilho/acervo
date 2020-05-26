package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.castelli.acervo.domain.Disco;
import com.castelli.acervo.services.DiscoService;

@RestController
@RequestMapping(value="/discos")
public class DiscoResource {
	
	@Autowired
	private DiscoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Disco> find(@PathVariable Integer id) {
		Disco obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
