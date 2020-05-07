package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Movimento;
import com.castelli.acervo.repositories.MovimentoRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class MovimentoService {

	@Autowired
	private MovimentoRepository repo;
	
	public Movimento find(Integer id) {
		Optional<Movimento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Movimento.class.getName()));
	}
}
