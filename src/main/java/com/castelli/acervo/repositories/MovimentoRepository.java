package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
