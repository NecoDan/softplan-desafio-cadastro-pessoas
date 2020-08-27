package br.com.softplan.api.rest.service.pessoas.util.domain;

public class CustomErrorType {

    private final String erroMensagem;

    public CustomErrorType(String erroMensagem) {
        this.erroMensagem = erroMensagem;
    }

    public String getErroMensagem() {
        return erroMensagem;
    }
}
