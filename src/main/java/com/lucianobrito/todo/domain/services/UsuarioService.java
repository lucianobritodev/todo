package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Usuario;
import com.lucianobrito.todo.domain.repositories.UsuarioRepository;
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
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Transactional
    public void deleteById(Long id) {
        Usuario usuarioDb = findAOneById(id);

        if (usuarioDb.getId() != null)
            usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioDb = findAOneById(id);
        if(usuarioDb.getId() != null) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }

        return new Usuario();
    }
}

