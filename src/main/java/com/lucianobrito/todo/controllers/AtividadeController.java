package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.Atividade;
import com.lucianobrito.todo.domain.services.AtividadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> findAll() {
        return atividadeService.findAll();
    }

    @GetMapping("/{id}")
    public Atividade findOneById(@PathVariable("id") Long id) {
        return atividadeService.findAOneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        atividadeService.deleteById(id);
    }

    @PostMapping
    public Atividade create(@RequestBody Atividade atividade) {
        return atividadeService.create(atividade);
    }

    @PutMapping("/{id}")
    public Atividade update(@PathVariable Long id, @RequestBody Atividade atividade) {
        return atividadeService.update(id, atividade);
    }

}
