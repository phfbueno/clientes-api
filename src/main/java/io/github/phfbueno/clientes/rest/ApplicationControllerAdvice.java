package io.github.phfbueno.clientes.rest;

import io.github.phfbueno.clientes.rest.excepetion.ApiErros;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect( Collectors.toList());
        return new ApiErros(messages);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity  handleResponseStautsException(ResponseStatusException ex) {
        String messageErro = ex.getMessage();
        HttpStatus statusErro  = ex.getStatus();
        ApiErros apiErros = new ApiErros(messageErro);
        return new ResponseEntity(apiErros,statusErro);
    }
}
