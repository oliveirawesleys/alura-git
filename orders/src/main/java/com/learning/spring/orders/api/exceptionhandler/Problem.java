package com.learning.spring.orders.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problem {

    private Integer status;
    private String title;
    private LocalDateTime dateHour;
    private List<Field> fields;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}
