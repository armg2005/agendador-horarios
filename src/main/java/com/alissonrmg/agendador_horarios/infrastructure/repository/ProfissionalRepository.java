package com.alissonrmg.agendador_horarios.infrastructure.repository;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
