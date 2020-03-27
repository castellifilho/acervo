package com.castelli.acervo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/paises")
public class PaisResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}
}
