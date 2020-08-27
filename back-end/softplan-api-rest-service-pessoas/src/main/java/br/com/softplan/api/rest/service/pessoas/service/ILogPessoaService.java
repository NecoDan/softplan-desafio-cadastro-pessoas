package br.com.softplan.api.rest.service.pessoas.service;

import br.com.softplan.api.rest.service.pessoas.model.LogPessoa;
import br.com.softplan.api.rest.service.pessoas.model.Pessoa;
import br.com.softplan.api.rest.service.pessoas.model.TipoOperacaoLogEnum;
import br.com.softplan.api.rest.service.pessoas.util.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.transaction.Transactional;
import java.util.List;

public interface ILogPessoaService {

    @Transactional(value = Transactional.TxType.NEVER)
    void salvarLogAuditoriaTransacaoPessoa(Pessoa pessoa, TipoOperacaoLogEnum tipoOperacaoLog) throws ServiceException;

    void salvarLogAuditoriaTransacaoPessoaAoDeletar(String conteudoJson, TipoOperacaoLogEnum tipoOperacaoLog) throws ServiceException;

    String gerarConteudoJsonFromPessoa(Pessoa pessoa) throws JsonProcessingException;

    @Transactional(value = Transactional.TxType.NEVER)
    void atualizarLogsPessoaFromList(List<LogPessoa> logPessoaList);

    List<LogPessoa> recuperarLogsPessoaPorPessoa(Pessoa pessoa);
}
