package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.Usuario;
import com.lucianobrito.todo.domain.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findOneById(@PathVariable("id") Long id) {
        return usuarioService.findAOneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

}
