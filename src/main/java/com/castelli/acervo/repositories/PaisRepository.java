package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
