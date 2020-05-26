package com.castelli.acervo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.repositories.FuncaoRepository;
import com.castelli.acervo.services.exceptions.DataIntegrityException;
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
	
	public Funcao insert(Funcao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcao update(Funcao obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma função que possui artista");
		}				
	}
	
	public List<Funcao> findAll() {
		return repo.findAll();
	}
	
	public Page<Funcao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
	                      Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
