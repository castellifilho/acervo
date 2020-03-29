package com.castelli.acervo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repo;
	
	public Pais find(Integer id) {
		Optional<Pais> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
