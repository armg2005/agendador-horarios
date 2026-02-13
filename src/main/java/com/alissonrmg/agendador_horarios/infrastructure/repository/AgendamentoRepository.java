package com.alissonrmg.agendador_horarios.infrastructure.repository;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;


public interface AgendamentoRepository extends JpaRepository<Agendamento , Long> {
   Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico,LocalDateTime datahorainicio ,LocalDateTime horafim);

    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime HoraInicial, LocalDateTime horaFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

}

