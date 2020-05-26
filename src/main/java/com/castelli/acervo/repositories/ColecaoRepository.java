package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Colecao;

public interface ColecaoRepository extends JpaRepository<Colecao, Integer> {
}
