package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.dto.AtividadeDto;
import com.lucianobrito.todo.domain.services.AtividadeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<AtividadeDto>> findAll() {
        List<AtividadeDto> atividades = atividadeService.findAll();
        return ResponseEntity.ok(atividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeDto> findOneById(@PathVariable("id") @Min(1) Long id) {
        AtividadeDto atividade = atividadeService.findAOneById(id);
        return ResponseEntity.ok(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        atividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtividadeDto create(@Valid @RequestBody AtividadeDto atividade) {
        return atividadeService.create(atividade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeDto> update(@PathVariable Long id, @Valid @RequestBody AtividadeDto atividade) {
        atividade = atividadeService.update(id, atividade);
        return ResponseEntity.ok(atividade);
    }

}
