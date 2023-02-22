package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Usuario;
import com.lucianobrito.todo.domain.entities.dto.UsuarioDto;
import com.lucianobrito.todo.domain.repositories.UsuarioRepository;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import lombok.*;
import lombok.experimental.WithBy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioDto> {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(ModelMapper mapper, UsuarioRepository usuarioRepository) {
        super(mapper);
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll()
                .stream().map(entity -> entityToDto(entity, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDto findAOneById(Long id) {
        return usuarioRepository.findById(id)
                .map(entity -> entityToDto(entity, UsuarioDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public void deleteById(Long id) {
        findAOneById(id);
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public UsuarioDto create(UsuarioDto usuarioDto) {
        Usuario usuario =  dtoToEntity(usuarioDto, Usuario.class);
        usuarioRepository.saveAndFlush(usuario);
        return entityToDto(usuario, UsuarioDto.class);
    }

    @Transactional
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        findAOneById(id);
        Usuario usuario = dtoToEntity(usuarioDto, Usuario.class);
        usuario.setId(id);
        usuarioRepository.saveAndFlush(usuario);
        return entityToDto(usuario, UsuarioDto.class);
    }

}

