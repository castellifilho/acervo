package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
