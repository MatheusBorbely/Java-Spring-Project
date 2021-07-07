package br.com.zup.projetozup.exception;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ErrorMessage {

    List<String> erros;

    public ErrorMessage(List<String> erros) {
        this.erros = erros;
    }

    public ErrorMessage(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }

    public List<String> getErros() {
        return erros;
    }
}
