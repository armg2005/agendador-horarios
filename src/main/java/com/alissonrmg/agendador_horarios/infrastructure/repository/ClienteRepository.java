package com.alissonrmg.agendador_horarios.infrastructure.repository;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long> {
}
