package com.castelli.acervo.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.domain.Funcao;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
	
	@Transactional(readOnly = true)
	Artista findByAlias(String alias);	
	//@Transactional(readOnly = true)
	//Artista findByNome(String nome);
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Artista obj INNER JOIN obj.funcoes fun WHERE obj.nome LIKE %:nome% AND fun IN :funcoes")
	Page<Artista> search(@Param("nome") String nome, @Param("funcoes") List<Funcao> funcoes, Pageable pageRequest);
}
