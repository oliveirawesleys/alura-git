package com.learning.spring.orders.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private String title;
    private OffsetDateTime dateHour;
    private List<Field> fields;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}
