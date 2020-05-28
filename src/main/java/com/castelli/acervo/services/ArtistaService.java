package com.castelli.acervo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.dto.ArtistaDTO;
import com.castelli.acervo.dto.ArtistaNewDTO;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.services.exceptions.DataIntegrityException;
import com.castelli.acervo.services.exceptions.ObjectNotFoundException;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository repo;
	
	public Artista find(Integer id) {
		Optional<Artista> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Artista.class.getName()));
	}
	
	public Artista insert(Artista obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Artista update(Artista obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir o artista.");
		}				
	}
	
	public List<Artista> findAll() {
		return repo.findAll();
	}
	
	public Page<Artista> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
	                      Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Artista fromDto(ArtistaDTO objDto) {
		return new Artista(objDto.getId(), objDto.getAlias(), objDto.getNome(), objDto.getNascimento(), objDto.getObito(), null);
	}
	
	public Artista fromDto(ArtistaNewDTO objDto) {
		Pais p = new Pais(objDto.getPaisId(), null);
		Artista a = new Artista(null, objDto.getAlias(), objDto.getNome(), objDto.getNascimento(), objDto.getObito(), p);
		Funcao f = new Funcao(objDto.getFuncaoId(), null);
		a.getFuncoes().add(f);
		f.getArtistas().add(a);
		return a;		
	}	
}
