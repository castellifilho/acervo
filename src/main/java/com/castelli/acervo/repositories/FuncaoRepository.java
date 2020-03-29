package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {
}
