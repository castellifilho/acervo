package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.MusicaArtistaFuncao;

@Repository
public interface MusicaArtistaFuncaoRepository extends JpaRepository<MusicaArtistaFuncao, Integer> {
}
