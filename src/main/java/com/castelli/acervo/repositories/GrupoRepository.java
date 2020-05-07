package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
}
