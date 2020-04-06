package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}
