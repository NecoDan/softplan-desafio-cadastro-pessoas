package br.com.softplan.api.rest.service.pessoas.service.validation;

import br.com.softplan.api.rest.service.pessoas.model.Pessoa;
import br.com.softplan.api.rest.service.pessoas.util.exceptions.ServiceException;

public interface IPessoaValidationService {

    void validarSomentePessoaIsValida(Pessoa pessoa) throws ServiceException;

    void validarPessoa(Pessoa pessoa) throws ServiceException;
}
