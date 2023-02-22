package com.lucianobrito.todo.domain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "usuario_gen", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario extends Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_gen")
    private Long id;
    @Column(columnDefinition = "varchar(60) not null")
    private String nome;

    @Column(columnDefinition = "varchar(50) not null unique", updatable = false)
    private String login;

    @Column(columnDefinition = "varchar(100) not null")
    private String senha;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Agenda> agendamentos = new ArrayList<>();

}

