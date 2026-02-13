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
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    @PostMapping("/post")
    public ResponseEntity<Agendamento> save (@RequestBody Agendamento agendameto){
        try {
            return ResponseEntity.ok(agendamentoService.save(agendameto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraAgendamento, @RequestParam String cliente){
        try {
            agendamentoService.delete(dataHoraAgendamento, cliente);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); // 400
        }
    }
    @GetMapping("/get")
    public ResponseEntity <List<Agendamento>> buscarAgendamentos(@RequestParam LocalDate date){
        try {
            return ResponseEntity.ok(agendamentoService.buscarAgendamentos(date));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/put")
    public ResponseEntity<Agendamento> alterarAgendamento (@RequestBody Agendamento agendamento,@RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente ){
        try {
            return ResponseEntity.ok(agendamentoService.alterarAgendamento(agendamento, dataHoraAgendamento ,cliente));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
