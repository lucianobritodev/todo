package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Usuario;
import com.lucianobrito.todo.domain.repositories.UsuarioRepository;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findAOneById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public void deleteById(Long id) {
        findAOneById(id);
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        findAOneById(id);
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

}

