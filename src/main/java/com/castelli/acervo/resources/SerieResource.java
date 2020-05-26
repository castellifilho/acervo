package com.castelli.acervo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.castelli.acervo.domain.Serie;
import com.castelli.acervo.services.SerieService;

@RestController
@RequestMapping(value="/series")
public class SerieResource {
	
	@Autowired
	private SerieService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Serie> find(@PathVariable Integer id) {
		Serie obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
