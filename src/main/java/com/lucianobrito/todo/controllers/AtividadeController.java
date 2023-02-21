package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.Atividade;
import com.lucianobrito.todo.domain.services.AtividadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<Atividade>> findAll() {
        List<Atividade> atividades = atividadeService.findAll();
        return ResponseEntity.ok(atividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findOneById(@PathVariable("id") Long id) {
        Atividade atividade = atividadeService.findAOneById(id);
        return ResponseEntity.ok(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        atividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atividade create(@RequestBody Atividade atividade) {
        return atividadeService.create(atividade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> update(@PathVariable Long id, @RequestBody Atividade atividade) {
        atividade = atividadeService.update(id, atividade);
        return ResponseEntity.ok(atividade);
    }

}
