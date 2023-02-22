package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Atividade;
import com.lucianobrito.todo.domain.entities.dto.AtividadeDto;
import com.lucianobrito.todo.domain.repositories.AtividadeRepository;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtividadeService extends BaseService<Atividade, AtividadeDto> {

    private final AtividadeRepository atividadeRepository;

    @Autowired
    public AtividadeService(ModelMapper mapper, AtividadeRepository atividadeRepository) {
        super(mapper);
        this.atividadeRepository = atividadeRepository;
    }

    @Transactional(readOnly = true)
    public Page<AtividadeDto> findAll(Pageable page) {
        return new PageImpl<>(atividadeRepository.findAll(page)
                .stream().map(entity -> entityToDto(entity, AtividadeDto.class))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public AtividadeDto findAOneById(Long id) {
        return atividadeRepository.findById(id)
                .map(entity -> entityToDto(entity, AtividadeDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public void deleteById(Long id) {
        findAOneById(id);
        atividadeRepository.deleteById(id);
    }

    @Transactional
    public AtividadeDto create(AtividadeDto atividadeDto) {
        Atividade atividade = dtoToEntity(atividadeDto, Atividade.class);
        atividadeRepository.saveAndFlush(atividade);
        return entityToDto(atividade, AtividadeDto.class);
    }

    @Transactional
    public AtividadeDto update(Long id, AtividadeDto atividadeDto) {
        findAOneById(id);
        Atividade atividade = dtoToEntity(atividadeDto, Atividade.class);
        atividade.setId(id);
        atividadeRepository.saveAndFlush(atividade);
        return entityToDto(atividade, AtividadeDto.class);
    }

}

