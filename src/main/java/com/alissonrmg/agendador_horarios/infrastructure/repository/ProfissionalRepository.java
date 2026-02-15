package com.alissonrmg.agendador_horarios.infrastructure.repository;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
