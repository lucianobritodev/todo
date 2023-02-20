package com.lucianobrito.todo.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "descricao", "data", "horario", "local"})
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "atividade_gen", sequenceName = "seq_atividade", allocationSize = 1)
public class Atividade extends Metadata implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atividade_gen")
    private Long id;
    private String descricao;
    private LocalDate data;
    private LocalTime horario;
    private String local;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
