package com.lucianobrito.todo.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "atividade_gen", sequenceName = "seq_atividade", allocationSize = 1)
public class Atividade extends Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atividade_gen")
    private Long id;

    @Column(columnDefinition = "varchar(200) not null")
    private String descricao;

    @Column(nullable = false, unique = true)
    private LocalTime horario;

    @Column(columnDefinition = "varchar(200) not null")
    private String local;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
