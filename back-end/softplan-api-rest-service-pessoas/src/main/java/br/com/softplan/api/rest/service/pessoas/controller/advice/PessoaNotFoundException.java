package br.com.softplan.api.rest.service.pessoas.controller.advice;

import java.util.UUID;

public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(UUID id) {
        super("Pessoa com {ID} " + id + " não encontrado e/ou localizado.");
    }
}
