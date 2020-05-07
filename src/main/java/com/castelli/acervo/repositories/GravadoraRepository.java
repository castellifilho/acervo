package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Gravadora;

public interface GravadoraRepository extends JpaRepository<Gravadora, Integer> {
}
