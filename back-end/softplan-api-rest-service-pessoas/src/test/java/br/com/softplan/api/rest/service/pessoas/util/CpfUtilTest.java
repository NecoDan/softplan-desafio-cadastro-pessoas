package br.com.softplan.api.rest.service.pessoas.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CpfUtilTest {

    @Before
    public void setUp() {
    }

    @Test
    public void deveValidarCpfEstahValidoERetornarVerdade() {
        log.info("#TEST: deveValidarCpfEstahValidoERetornarVerdade: ");

        // -- 01_Cenário
        String cpf = GeraCpfUtil.cpf(true);
        log.info("CPF: ".concat(cpf));

        // -- 02_Ação && -- 03_Verificacao-Validacao
        assertTrue(CpfUtil.isCPFValido(cpf));
        log.info("-------------------------------------------------------------");
    }

    @Test
    public void deveValidarCpfEstahValidoERetornarFalso() {
        log.info("#TEST: deveValidarCpfEstahValidoERetornarFalso: ");

        // -- 01_Cenário
        String cpf = String.valueOf(RandomicoUtil.gerarValorRandomicoLong());
        log.info("CPF: ".concat(cpf));

        // -- 02_Ação && -- 03_Verificacao-Validacao
        assertFalse(CpfUtil.isCPFValido(cpf));
        log.info("-------------------------------------------------------------");
    }
}
