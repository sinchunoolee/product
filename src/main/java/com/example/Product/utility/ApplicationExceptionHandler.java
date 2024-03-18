package com.example.Product.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    private ErrorStructure struct;

    public ApplicationExceptionHandler(ErrorStructure struct) {
        super();
        this.struct = struct;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		List<ObjectError> allErrors = ex.getAllErrors();
        Map<String,String> messages=new HashMap<>();
        ex.getAllErrors().forEach(error->messages.put(((FieldError)error).getField(),error.getDefaultMessage()));
//		{
//			FieldError fieldError=(FieldError)err;
//			errors.put(((FieldError)err).getField(),err.getDefaultMessage());
//		});
        return ResponseEntity.badRequest().body(struct.setRootCause(messages).
                setErrorMessage("Invalid data entered").
                setStatuscode(HttpStatus.BAD_REQUEST.value()));
    }
}
