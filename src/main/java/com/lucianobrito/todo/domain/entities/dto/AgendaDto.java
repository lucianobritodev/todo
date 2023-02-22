package com.lucianobrito.todo.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucianobrito.todo.domain.entities.Metadata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "titulo", "data", "atividades"})
public class AgendaDto extends Metadata implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 100, message = "Tamanho máximo excedido!")
    private String titulo;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    private LocalDate data;


    private List<AtividadeDto> atividades;

}
