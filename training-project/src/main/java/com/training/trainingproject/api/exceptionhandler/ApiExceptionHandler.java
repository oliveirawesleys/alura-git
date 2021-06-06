package com.training.trainingproject.api.exceptionhandler;

import com.training.trainingproject.domain.exception.BusinessException;
import com.training.trainingproject.domain.exception.EntityNotFoundException;
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

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(BusinessException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var problem = new Problem();

        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var problem = new Problem();

        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

                               @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                               HttpStatus status, WebRequest request) {
        var fields = new ArrayList<Problem.Field>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new Problem.Field(name, message));
        }

        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle("Um ou mais campos estão inválidos!");
        problem.setDateTime(LocalDateTime.now());
        problem.setFieldList(fields);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
