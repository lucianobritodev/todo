package com.lucianobrito.todo.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseError {

    private Integer status;
    private ZonedDateTime dateTime;
    private String error;
    private String path;
    private List<Field> fields;

    @Data
    @AllArgsConstructor
    public static class Field {

        private String name;
        private String message;

    }

}
