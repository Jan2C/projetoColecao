package com.projeto.projetoColecao.repositories;

import com.projeto.projetoColecao.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}
