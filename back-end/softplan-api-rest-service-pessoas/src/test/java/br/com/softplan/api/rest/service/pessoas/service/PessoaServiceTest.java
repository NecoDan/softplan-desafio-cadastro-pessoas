package br.com.softplan.api.rest.service.pessoas.service;

import br.com.softplan.api.rest.service.pessoas.model.dominio.Pessoa;
import br.com.softplan.api.rest.service.pessoas.model.enums.TipoSexo;
import br.com.softplan.api.rest.service.pessoas.repository.negocio.IPessoaRepository;
import br.com.softplan.api.rest.service.pessoas.service.negocio.PessoaService;
import br.com.softplan.api.rest.service.pessoas.service.validation.PessoaValidationService;
import br.com.softplan.api.rest.service.pessoas.util.GeraCpfUtil;
import br.com.softplan.api.rest.service.pessoas.util.RandomicoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
public class PessoaServiceTest {

    @Mock
    private IPessoaRepository pessoaRepository;
    @Mock
    private PessoaValidationService pessoaValidationService;
    @Spy
    @InjectMocks
    private PessoaService pessoaServiceMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private void resetarMocks() {
        reset(pessoaRepository);
        reset(pessoaValidationService);
        reset(pessoaServiceMock);
    }

    @Test
    public void deveRecuperarPorIdUmaUnicaPesssoa() {
        log.info("{} ", "#TEST: deveRecuperarPorIdUmaUnicaPesssoa: ");

        // -- 01_Cenário
        resetarMocks();
        UUID id = UUID.randomUUID();
        Pessoa pessoa = mock(Pessoa.class);

        // -- 01_Cenário && 02_Ação
        doCallRealMethod().when(pessoaServiceMock).recuperarPorId(any(UUID.class));
        when(pessoaServiceMock.recuperarPorId(id)).thenReturn(Optional.of(pessoa));

        // -- 03_Verificação_Validação
        assertTrue(pessoaServiceMock.recuperarPorId(id).isPresent());
        log.info("{} ", "-------------------------------------------------------------");
    }

    @Test
    public void deveRecuperarTodosUmaListaPessoasPaginavel() {
        log.info("{} ", "#TEST: deveRecuperarTodosUmaListaPessoasPaginavel: ");

        // -- 01_Cenário
        resetarMocks();
        Pageable pageable = PageRequest.of(0, 8);
        List<Pessoa> pessoaList = Arrays.asList(mock(Pessoa.class), mock(Pessoa.class), mock(Pessoa.class), mock(Pessoa.class));
        Page<Pessoa> pessoaPage = new PageImpl<>(pessoaList);

        // -- 02_Ação
        doCallRealMethod().when(pessoaServiceMock).recuperarTodos(isA(Pageable.class));
        when(pessoaServiceMock.recuperarTodos(pageable)).thenReturn(pessoaPage);

        // -- 03_Verificação_Validação
        assertEquals(pessoaPage, pessoaServiceMock.recuperarTodos(pageable));
        log.info("{} ", "-------------------------------------------------------------");
    }

    private Pessoa constroiPessoaValida(UUID id) {
        Pessoa pessoa = Pessoa.builder()
                .nome(String.valueOf(RandomicoUtil.gerarValorRandomico()))
                .cpf(GeraCpfUtil.cpf(false))
                .dataNascimento(LocalDate.now())
                .tipoSexo(TipoSexo.M)
                .endereco(String.valueOf(RandomicoUtil.gerarValorRandomico()))
                .build();

        pessoa.setId(Objects.isNull(id) ? UUID.randomUUID() : id);
        pessoa.ativado();
        pessoa.gerarDataCorrente();
        return pessoa;
    }

}
