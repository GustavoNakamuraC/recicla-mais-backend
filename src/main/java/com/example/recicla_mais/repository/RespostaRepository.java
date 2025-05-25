package com.example.recicla_mais.repository;

import com.example.recicla_mais.repository.entity.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Long> {
    List<RespostaEntity> findAllByPublicacaoId(Long id);
}
