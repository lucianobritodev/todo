package com.lucianobrito.todo.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucianobrito.todo.domain.entities.Metadata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "descricao", "horario", "local"})
public class AtividadeDto extends Metadata {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 200, message = "Tamanho máximo excedido!")
    private String descricao;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    private LocalTime horario;

    @NotBlank(message = "Não pode ser vazio ou nulo!")
    @Size(max = 200, message = "Tamanho máximo excedido!")
    private String local;

}
