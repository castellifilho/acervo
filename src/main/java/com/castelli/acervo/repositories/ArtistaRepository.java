package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}
