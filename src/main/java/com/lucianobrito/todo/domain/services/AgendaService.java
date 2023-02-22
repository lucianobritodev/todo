package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Agenda;
import com.lucianobrito.todo.domain.entities.dto.AgendaDto;
import com.lucianobrito.todo.domain.repositories.AgendaRepository;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaService extends BaseService<Agenda, AgendaDto> {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(ModelMapper mapper, AgendaRepository agendaRepository) {
        super(mapper);
        this.agendaRepository = agendaRepository;
    }

    @Transactional(readOnly = true)
    public List<AgendaDto> findAll() {
        return agendaRepository.findAll()
                .stream().map(entity -> entityToDto(entity, AgendaDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AgendaDto findAOneById(Long id) {
        return agendaRepository.findById(id)
                .map(entity -> entityToDto(entity, AgendaDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public void deleteById(Long id) {
        findAOneById(id);
        agendaRepository.deleteById(id);
    }

    @Transactional
    public AgendaDto create(AgendaDto agendaDto) {
        Agenda agenda = dtoToEntity(agendaDto, Agenda.class);
        agendaRepository.saveAndFlush(agenda);
        return entityToDto(agenda, AgendaDto.class);
    }

    @Transactional
    public AgendaDto update(Long id, AgendaDto agendaDto) {
        findAOneById(id);
        Agenda agenda = dtoToEntity(agendaDto, Agenda.class);
        agenda.setId(id);
        agendaRepository.saveAndFlush(agenda);
        return entityToDto(agenda, AgendaDto.class);
    }
    
}

