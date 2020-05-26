package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.FaixaCredito;

public interface FaixaCreditoRepository extends JpaRepository<FaixaCredito, Integer> {
}
