package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Selo;

public interface SeloRepository extends JpaRepository<Selo, Integer> {
}
