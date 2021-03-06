package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.Funcao;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {
}
