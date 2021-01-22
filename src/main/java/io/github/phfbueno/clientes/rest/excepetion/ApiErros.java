package io.github.phfbueno.clientes.rest.excepetion;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

    @Getter
    private List<String> erros;

    public ApiErros(List<String> erros){
        this.erros = erros;
    }

    public ApiErros(String messages){
        this.erros = Arrays.asList(messages);
    }
}
