package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelli.acervo.domain.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
