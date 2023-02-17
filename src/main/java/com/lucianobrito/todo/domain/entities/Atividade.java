package com.lucianobrito.todo.domain.entities;

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
    private String descricao;
    private LocalDate data;
    private LocalTime horario;
    private String local;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
