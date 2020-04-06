package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
