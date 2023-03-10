package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.dto.AgendaDto;
import com.lucianobrito.todo.domain.services.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class AgendaController {

    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<Page<AgendaDto>> findAll(Pageable page) {
        Page<AgendaDto> agendamentos = agendaService.findAll(page);
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDto> findOneById(@PathVariable("id") Long id) {
        AgendaDto agendamento = agendaService.findAOneById(id);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendaDto create(@RequestBody AgendaDto agendaDto) {
        return agendaService.create(agendaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaDto> update(@PathVariable Long id, @RequestBody AgendaDto agendaDto) {
        agendaDto = agendaService.update(id, agendaDto);
        return ResponseEntity.ok(agendaDto);
    }

}
