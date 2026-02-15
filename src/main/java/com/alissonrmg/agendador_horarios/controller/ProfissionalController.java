package com.alissonrmg.agendador_horarios.controller;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Cliente;
import com.alissonrmg.agendador_horarios.infrastructure.entity.Profissional;
import com.alissonrmg.agendador_horarios.services.ProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profissionais")
public class ProfissionalController {
    private final ProfissionalService profissionalService;
    @PostMapping
    public ResponseEntity<Profissional> save (@RequestBody Profissional profissional){
        try {
            return ResponseEntity.ok(profissionalService.save(profissional));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        try {
            profissionalService.deleteProfissional(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity <List<Profissional>> buscarProfisional (){
        try {
            return ResponseEntity.ok(profissionalService.buscarProfissional());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity <Profissional> buscarClientesById (@PathVariable Long id){
        try {
            return ResponseEntity.ok(profissionalService.buscarProfissionalById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{profissionalId}")
    public ResponseEntity<Profissional> alterarProfissional (@PathVariable Long profissionalId , @RequestBody Profissional profissional){
        try {
            return ResponseEntity.ok(profissionalService.alterarProfissional(profissional, profissionalId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
