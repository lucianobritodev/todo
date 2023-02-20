package com.lucianobrito.todo.domain.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "nome", "login", "senha", "agendamentos"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "usuario_gen", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario extends Metadata implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_gen")
    private Long id;
    @Column(columnDefinition = "varchar(150) not null")
    private String nome;

    @Column(columnDefinition = "varchar(70) not null unique", updatable = false)
    private String login;

    @Column(columnDefinition = "varchar(150) not null")
    private String senha;

    @JsonManagedReference
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Agenda> agendamentos = new ArrayList<>();

}

