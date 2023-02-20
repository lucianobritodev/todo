package com.lucianobrito.todo.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "descricao", "atividades"})
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "agenda_gen", sequenceName = "seq_agenda", allocationSize = 1)
public class Agenda extends Metadata implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_gen")
    private Long id;

    @Column(columnDefinition = "varchar(100) not null", unique = true)
    private String descricao;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agenda")
    private List<Atividade> atividades;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
