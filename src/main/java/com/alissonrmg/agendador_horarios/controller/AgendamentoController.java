package com.alissonrmg.agendador_horarios.controller;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Agendamento;
import com.alissonrmg.agendador_horarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity <Agendamento> save (@RequestBody Agendamento agendameto){
        try {
            return ResponseEntity.ok(agendamentoService.save(agendameto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> delete (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraAgendamento, @PathVariable Long clienteId){
        try {
            agendamentoService.delete(dataHoraAgendamento, clienteId);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); // 400
        }
    }
    @GetMapping
    public ResponseEntity <List<Agendamento>> buscarAgendamentos(@RequestParam LocalDate date){
        try {
            return ResponseEntity.ok(agendamentoService.buscarAgendamentos(date));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{clienteId}")
    public ResponseEntity<Agendamento> alterarAgendamento (@RequestBody Agendamento agendamento,@RequestParam LocalDateTime dataHoraAgendamento, @PathVariable Long clienteId ){
        try {
            return ResponseEntity.ok(agendamentoService.alterarAgendamento(agendamento, dataHoraAgendamento ,clienteId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
