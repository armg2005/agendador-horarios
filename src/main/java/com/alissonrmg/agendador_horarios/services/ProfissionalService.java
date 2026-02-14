package com.alissonrmg.agendador_horarios.services;

import com.alissonrmg.agendador_horarios.infrastructure.entity.Profissional;
import com.alissonrmg.agendador_horarios.infrastructure.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProfissionalService {
    private final ProfissionalRepository profissionalRepository;
    public Profissional save (Profissional profissional){
        return profissionalRepository.save(profissional);
    }
    public void deleteProfissional (Long profissionalID){
        profissionalRepository.deleteById(profissionalID);
    }
    public List<Profissional> buscarProfissional(){
        return profissionalRepository.findAll();
    }
    public Profissional alterarProfissional(Profissional profissional , Long id){
        Profissional profissional1 = profissionalRepository.findById(id).orElse(null);
        if (Objects.nonNull(profissional1)){
            profissional.setId(profissional1.getId());
            return  profissionalRepository.save(profissional);
        }
        throw  new RuntimeException("Profissional não entrado para ser alterado ");
    }
}
