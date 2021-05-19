package com.training.trainingproject.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private LocalDateTime dateTime;
    private String title;
    private List<Field> fieldList;

    @Data
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}
