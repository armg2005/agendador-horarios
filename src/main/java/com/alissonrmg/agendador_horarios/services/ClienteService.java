package com.alissonrmg.agendador_horarios.services;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Cliente;
import com.alissonrmg.agendador_horarios.infrastructure.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public void deleteCliente (Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
    public List<Cliente> buscarClientes(){
       return clienteRepository.findAll();
    }
    public Cliente buscarClientesById(Long id){
        Cliente cliente= clienteRepository.findById(id).orElse(null);
        if (Objects.isNull(cliente)){
            throw new RuntimeException("Cliente não encontrado ");
        }
        return cliente;
    }
    public Cliente alterarCliente(Cliente cliente , Long id){
        Cliente cliente1 = clienteRepository.findById(id).orElse(null);
        if (Objects.nonNull(cliente1)){
            cliente.setId(cliente1.getId());
            return clienteRepository.save(cliente);
        }
        throw  new RuntimeException("Cliente não entrado para ser alterado ");
    }

}
