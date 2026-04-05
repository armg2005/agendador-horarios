package com.alissonrmg.agendador_horarios.infrastructure.dto.response;

import java.time.LocalDateTime;

public record AuxiliaresDtos() {
    // DTOs auxiliares para não expor a Entidade
    public record ClienteResumoResponse(Long id, String nome) {
    }

    public record ProfissionalResumoResponse(Long id, String nome) {
    }

    public record AgendamentoResumoResponse(Long id, String servico, LocalDateTime dataHoraAgendamento) {
    }
}