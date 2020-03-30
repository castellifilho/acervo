package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.repositories.FuncaoRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class FuncaoService {

	@Autowired
	private FuncaoRepository repo;
	
	public Funcao find(Integer id) {
		Optional<Funcao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcao.class.getName()));
	}
}
