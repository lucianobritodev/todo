package com.lucianobrito.todo.domain.repositories;

import com.lucianobrito.todo.domain.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
