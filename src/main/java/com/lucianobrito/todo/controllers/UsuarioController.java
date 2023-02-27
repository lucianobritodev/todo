package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.dto.UsuarioDto;
import com.lucianobrito.todo.domain.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> findAll(Pageable page) {
        Page<UsuarioDto> usuarios = usuarioService.findAll(page);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findOneById(@PathVariable("id") Long id) {
        UsuarioDto usuarioDto = usuarioService.findAOneById(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.create(usuarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @Valid @RequestBody UsuarioDto usuarioDto) {
        usuarioDto = usuarioService.update(id, usuarioDto);
        return ResponseEntity.ok(usuarioDto);
    }

}
