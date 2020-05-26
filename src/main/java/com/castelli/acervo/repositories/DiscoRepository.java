package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Disco;

public interface DiscoRepository extends JpaRepository<Disco, Integer> {
}
