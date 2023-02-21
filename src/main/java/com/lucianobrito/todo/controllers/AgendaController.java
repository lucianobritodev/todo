package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.Agenda;
import com.lucianobrito.todo.domain.services.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class AgendaController {

    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<Agenda>> findAll() {
        List<Agenda> agendamentos = agendaService.findAll();
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> findOneById(@PathVariable("id") Long id) {
        Agenda agendamento = agendaService.findAOneById(id);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda create(@RequestBody Agenda agenda) {
        return agendaService.create(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> update(@PathVariable Long id, @RequestBody Agenda agenda) {
        agenda = agendaService.update(id, agenda);
        return ResponseEntity.ok(agenda);
    }

}
