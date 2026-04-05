package com.alissonrmg.agendador_horarios.infrastructure.dto.response;

import java.time.LocalDateTime;

public record AgendamentoResponse(Long id, String servico, LocalDateTime dataHoraAgendamento, LocalDateTime dataInsercao,
                                  AuxiliaresDtos.ClienteResumoResponse cliente, AuxiliaresDtos.ProfissionalResumoResponse profissional) {
}
