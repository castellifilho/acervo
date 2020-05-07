package com.castelli.acervo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelli.acervo.domain.MusicaMovimento;

@Repository
public interface MusicaMovimentoRepository extends JpaRepository<MusicaMovimento, Integer> {
}
