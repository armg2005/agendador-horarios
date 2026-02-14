package com.alissonrmg.agendador_horarios.controller;
import com.alissonrmg.agendador_horarios.infrastructure.entity.Cliente;
import com.alissonrmg.agendador_horarios.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Cliente> save (@RequestBody Cliente cliente){
        try {
            return ResponseEntity.ok(clienteService.save(cliente));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity <List<Cliente>> buscarClientes (){
        try {
            return ResponseEntity.ok(clienteService.buscarClientes());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> alterarCliente (@PathVariable Long clienteId , @RequestBody Cliente cliente){
        try {
            return ResponseEntity.ok(clienteService.alterarCliente(cliente, clienteId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
