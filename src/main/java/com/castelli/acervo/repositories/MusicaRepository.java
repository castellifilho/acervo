package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
