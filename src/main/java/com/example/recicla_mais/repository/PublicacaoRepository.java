package com.example.recicla_mais.repository;

import com.example.recicla_mais.repository.entity.PublicacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends JpaRepository<PublicacaoEntity, Long> {
}
