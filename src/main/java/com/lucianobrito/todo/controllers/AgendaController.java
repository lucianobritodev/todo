package com.lucianobrito.todo.controllers;

import com.lucianobrito.todo.domain.entities.Agenda;
import com.lucianobrito.todo.domain.services.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class AgendaController {

    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> findAll() {
        return agendaService.findAll();
    }

    @GetMapping("/{id}")
    public Agenda findOneById(@PathVariable("id") Long id) {
        return agendaService.findAOneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        agendaService.deleteById(id);
    }

    @PostMapping
    public Agenda create(@RequestBody Agenda agenda) {
        return agendaService.create(agenda);
    }

    @PutMapping("/{id}")
    public Agenda update(@PathVariable Long id, @RequestBody Agenda agenda) {
        return agendaService.update(id, agenda);
    }

}
