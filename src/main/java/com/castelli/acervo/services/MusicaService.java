package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Musica;
import com.castelli.acervo.repositories.MusicaRepository;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class MusicaService {

	@Autowired
	private MusicaRepository repo;
	
	public Musica find(Integer id) {
		Optional<Musica> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Musica.class.getName()));
	}
}
