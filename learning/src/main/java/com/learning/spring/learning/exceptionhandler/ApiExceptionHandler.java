package com.learning.spring.learning.exceptionhandler;

import com.learning.spring.learning.domain.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handlerBusiness(BusinessException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDate(LocalDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                    HttpHeaders headers, HttpStatus status, WebRequest request) {

        var labels = new ArrayList<Problem.Label>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError)error).getField();
            //use to default message
            //String message = error.getDefaultMessage();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            labels.add(new Problem.Label(name, message));
        }

        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle("Um ou mais campos estão invalidos. Faça o preenchimento correto e tente novamente");
        problem.setDate(LocalDateTime.now());
        problem.setLabels(labels);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
