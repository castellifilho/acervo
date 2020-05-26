package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Faixa;

public interface FaixaRepository extends JpaRepository<Faixa, Integer> {
}
