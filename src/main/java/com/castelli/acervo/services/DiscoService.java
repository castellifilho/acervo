package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Disco;
import com.castelli.acervo.repositories.DiscoRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class DiscoService {

	@Autowired
	private DiscoRepository repo;
	
	public Disco find(Integer id) {
		Optional<Disco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Disco.class.getName()));
	}
}
