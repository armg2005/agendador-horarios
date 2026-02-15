package com.alissonrmg.agendador_horarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataInsercao =LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Profissional profissional;
}
