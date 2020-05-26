package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Serie;
import com.castelli.acervo.repositories.SerieRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class SerieService {

	@Autowired
	private SerieRepository repo;
	
	public Serie find(Integer id) {
		Optional<Serie> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Serie.class.getName()));
	}
}
