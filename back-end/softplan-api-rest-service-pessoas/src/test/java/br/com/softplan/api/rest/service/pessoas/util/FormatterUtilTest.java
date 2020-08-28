package br.com.softplan.api.rest.service.pessoas.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Slf4j
public class FormatterUtilTest {

    @Before
    public void setUp() {
    }

    @Test
    public void deveRetirarCaracteresNaoNumericosDeUmaString() {
        log.info("#TEST: deveRetirarCaracteresNaoNumericosDeUmaString: ");

        // -- 01_Cenário
        String texto = GeraCpfUtil.cpf(true);
        log.info("String com caracters: ".concat(texto));

        // -- 02_Ação
        String resultSemCaracters = FormatterUtil.retirarCaracteresNaoNumericos(texto);

        // -- 03_Verificacao-Validacao
        assertTrue(!resultSemCaracters.contains(".") || !resultSemCaracters.contains("-"));

        log.info("String sem caracters: ".concat(resultSemCaracters));
        log.info("-------------------------------------------------------------");
    }

    @Test
    public void deveRetornarConteudoStringAPartirLocalDateFormatadaPorFormatoParam() {
        log.info("{} ", "#TEST: deveRetornarConteudoStringAPartirLocalDateFormatadaPorFormatoParam: ");

        // -- 01_Cenário
        LocalDate d = LocalDate.now();

        // -- 02_Ação
        String result = FormatterUtil.toStringLocalDateFormatadaPor(d, "yyyyMMdd");

        // -- 03_Verificacao-Validacao
        assertFalse(result.isEmpty());

        log.info("{} ", "Result_Data_Formata: ".concat(result));
        log.info("{} ", "-------------------------------------------------------------");
    }

    @Test
    public void deveRetornarConteudoStringAPartirLocalDateFormatado() {
        log.info("{} ", "#TEST: deveRetornarConteudoStringAPartirLocalDateFormatado: ");

        // -- 01_Cenário
        LocalDate d = LocalDate.now();

        // -- 02_Ação
        String result = FormatterUtil.toStringLocalDateFormatada(d);

        // -- 03_Verificacao-Validacao
        assertFalse(result.isEmpty());

        log.info("{} ", "Result_Data_Formata: ".concat(result));
        log.info("{} ", "-------------------------------------------------------------");
    }


}
