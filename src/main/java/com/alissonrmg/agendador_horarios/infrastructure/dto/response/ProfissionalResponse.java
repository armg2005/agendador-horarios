package com.alissonrmg.agendador_horarios.infrastructure.dto.response;

import java.util.List;

public record ProfissionalResponse(Long id, String nome, List<AuxiliaresDtos.AgendamentoResumoResponse> agendamentos) {
}
