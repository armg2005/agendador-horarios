package com.alissonrmg.agendador_horarios.services;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Agendamento;
import com.alissonrmg.agendador_horarios.infrastructure.entity.Cliente;
import com.alissonrmg.agendador_horarios.infrastructure.entity.Profissional;
import com.alissonrmg.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import com.alissonrmg.agendador_horarios.infrastructure.repository.ClienteRepository;
import com.alissonrmg.agendador_horarios.infrastructure.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;

    public Agendamento save(Agendamento agendamento){
        Cliente cliente = clienteRepository.findById(agendamento.getCliente().getId()).orElse(null);
        if (Objects.isNull(cliente)){
            throw new RuntimeException("Cliente não encontrado");
        }
        Profissional profissional= profissionalRepository.findById(agendamento.getProfissional().getId()).orElse(null);
        if (Objects.isNull(profissional)){
            throw new RuntimeException("Cliente não encontrado");
        }
        agendamento.setCliente(cliente);
        agendamento.setProfissional(profissional);

        agendamento.setDataInsercao(LocalDateTime.now());

        LocalDateTime horaagendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByProfissionalIdAndDataHoraAgendamentoBetween(agendamento.getProfissional().getId(), horaagendamento,horaFim);
        if(Objects.isNull(agendados)){
           return agendamentoRepository.save(agendamento);
        }else {
            throw new RuntimeException ("Horario indisponível");
        }
    }
    public void delete(LocalDateTime dataHoraAgendamento, Long clienteId){
        agendamentoRepository.deleteByDataHoraAgendamentoAndClienteId(dataHoraAgendamento,clienteId);

    }
    public List<Agendamento> buscarAgendamentos (LocalDate data){
        LocalDateTime primeiraHoraDoDia = data.atStartOfDay();
        LocalDateTime horaFinal = data.atTime(23,59,59);
        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDoDia ,horaFinal);
    }
    public Agendamento alterarAgendamento (Agendamento agendamento, LocalDateTime dataHoraAgendamento ,Long cliente){
        Agendamento agenda= agendamentoRepository.findByDataHoraAgendamentoAndClienteId(dataHoraAgendamento , cliente);
        if (Objects.isNull(agenda)){
            throw new RuntimeException ("Esse horario não esta preenchido");
        }
        agendamento.setId(agenda.getId());
        return agendamentoRepository.save(agendamento);
    }



}
