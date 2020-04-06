package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
