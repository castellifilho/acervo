package com.castelli.acervo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.dto.ArtistaDTO;
import com.castelli.acervo.dto.ArtistaNewDTO;
import com.castelli.acervo.resources.utils.URL;
import com.castelli.acervo.services.ArtistaService;

@RestController
@RequestMapping(value = "/artistas")
public class ArtistaResource {
	@Autowired
	private ArtistaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Artista> find(@PathVariable Integer id) {
		Artista obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ArtistaNewDTO objDto){
		Artista obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ArtistaDTO objDto,
			@PathVariable Integer id){
		Artista obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//@RequestMapping(method=RequestMethod.GET)
	//public ResponseEntity<List<ArtistaDTO>> findAll() {
	//	List<Artista> lista = service.findAll();
	//	List<ArtistaDTO> listaDto = lista.stream().map(obj -> new 
	//                    ArtistaDTO(obj)).collect(Collectors.toList()); 
	//	return ResponseEntity.ok().body(listaDto);			
	//}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ArtistaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Artista> lista = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ArtistaDTO> listaDto = lista.map(obj -> new ArtistaDTO(obj)); 
		return ResponseEntity.ok().body(listaDto);				
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ArtistaDTO>> findPage(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "funcoes", defaultValue = "") String funcoes,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nomeDecode = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(funcoes);
		Page<Artista> list = service.search(nomeDecode, ids, page, linesPerPage, orderBy, direction);
		Page<ArtistaDTO> listDto = list.map(obj -> new ArtistaDTO(obj)); 
		return ResponseEntity.ok().body(listDto);				
	}
}