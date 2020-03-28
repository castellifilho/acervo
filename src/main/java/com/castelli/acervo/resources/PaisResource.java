package com.castelli.acervo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.castelli.acervo.domain.Pais;

@RestController
@RequestMapping(value="/paises")
public class PaisResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Pais> find() {
		Pais p1 = new Pais(1, "Alemanha");
		Pais p2 = new Pais(2, "Brasil");
		List<Pais> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		return lista;
	}
}
