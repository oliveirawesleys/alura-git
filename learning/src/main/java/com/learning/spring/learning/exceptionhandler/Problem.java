package com.learning.spring.learning.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private LocalDateTime date;
    private String title;
    private List<Label> labels;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Label {
        private String name;
        private String message;
    }
}
