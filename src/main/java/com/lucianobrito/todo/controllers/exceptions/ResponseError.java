package com.lucianobrito.todo.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseError {

    private Integer status;

    @JsonProperty("data_hora")
    private ZonedDateTime dateTime;

    @JsonProperty("erro")
    private String error;

    @JsonProperty("caminho")
    private String path;

    @JsonProperty("campos")
    private List<Field> fields;

    @Data
    @AllArgsConstructor
    public static class Field {

        @JsonProperty("nome")
        private String name;

        @JsonProperty("mensagem")
        private String message;

    }

}
