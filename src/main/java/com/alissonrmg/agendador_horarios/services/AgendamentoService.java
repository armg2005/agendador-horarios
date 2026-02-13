package com.alissonrmg.agendador_horarios.services;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Agendamento;
import com.alissonrmg.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento save(Agendamento agendamento){
        LocalDateTime horaagendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaagendamento,horaFim);
        if(Objects.isNull(agendados)){
           return agendamentoRepository.save(agendamento);
        }else {
            throw new RuntimeException ("Horario indiponivel");
        }
    }
    public void delete(LocalDateTime dataHoraAgendamento, String cliente){
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento,cliente);

    }
    public List<Agendamento> buscarAgendamentos (LocalDate data){
        LocalDateTime primeiraHoraDoDia = data.atStartOfDay();
        LocalDateTime horaFinal = data.atTime(23,59,59);
        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDoDia ,horaFinal);
    }
    public Agendamento alterarAgendamento (Agendamento agendamento, LocalDateTime dataHoraAgendamento ,String cliente){
        Agendamento agenda= agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento , cliente);
        if (Objects.isNull(agenda)){
            throw new RuntimeException ("Esse horario não esta preenchido");
        }
        agendamento.setId(agenda.getId());
        return agendamentoRepository.save(agendamento);
    }



}
