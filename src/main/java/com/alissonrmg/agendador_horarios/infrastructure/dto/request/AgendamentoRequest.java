package com.alissonrmg.agendador_horarios.infrastructure.dto.request;

import java.time.LocalDateTime;

public record AgendamentoRequest(String servico, LocalDateTime dataHoraAgendamento,
                                 Long clienteId, Long profissionalId) {
}
