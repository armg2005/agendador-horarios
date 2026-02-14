package com.alissonrmg.agendador_horarios.infrastructure.repository;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento , Long> {
   Agendamento findByProfissionalIdAndDataHoraAgendamentoBetween(Long profissionalId,LocalDateTime datahorainicio ,LocalDateTime horafim);

    @Transactional
    void deleteByDataHoraAgendamentoAndClienteId(LocalDateTime dataHoraAgendamento, Long clienteId);

    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime HoraInicial, LocalDateTime horaFinal);

    Agendamento findByDataHoraAgendamentoAndClienteId(LocalDateTime dataHoraAgendamento, Long clienteId);

}

