package com.alissonrmg.agendador_horarios.infrastructure.dto.response;


import java.util.List;

public record ClienteResponse(Long id, String nome, String telefone, List<AuxiliaresDtos.AgendamentoResumoResponse> agendamentos) {
}
