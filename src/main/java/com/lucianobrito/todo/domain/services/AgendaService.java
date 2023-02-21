package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Agenda;
import com.lucianobrito.todo.domain.repositories.AgendaRepository;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AgendaService {

    private AgendaRepository agendaRepository;

    @Transactional(readOnly = true)
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Agenda findAOneById(Long id) {
        return agendaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public void deleteById(Long id) {
        findAOneById(id);
        agendaRepository.deleteById(id);
    }

    @Transactional
    public Agenda create(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @Transactional
    public Agenda update(Long id, Agenda agenda) {
        findAOneById(id);
        agenda.setId(id);
        return agendaRepository.save(agenda);
    }
    
}

