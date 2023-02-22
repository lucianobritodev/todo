package com.lucianobrito.todo.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucianobrito.todo.domain.entities.Agenda;
import com.lucianobrito.todo.domain.entities.Metadata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "nome", "login", "agendamentos"})
public class UsuarioDto extends Metadata implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 150, message = "Tamanho máximo excedido!")
    private String nome;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 70, message = "Tamanho máximo excedido!")
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 150, message = "Tamanho máximo excedido!")
    private String senha;

    private List<AgendaDto> agendamentos = new ArrayList<>();

}
