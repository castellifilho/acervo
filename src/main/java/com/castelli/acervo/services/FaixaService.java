package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Faixa;
import com.castelli.acervo.repositories.FaixaRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class FaixaService {

	@Autowired
	private FaixaRepository repo;
	
	public Faixa find(Integer id) {
		Optional<Faixa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Faixa.class.getName()));
	}
}
