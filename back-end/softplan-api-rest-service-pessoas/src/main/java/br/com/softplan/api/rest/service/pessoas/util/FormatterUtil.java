package br.com.softplan.api.rest.service.pessoas.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class FormatterUtil {

    private static final String MENSAGEM_VALIDACAO = "Parâmetro {DATA}, encontra-se inválida e/ou inexistente.";

    private FormatterUtil() {
    }

    public static String retirarCaracteresNaoNumericos(String value) {
        return (Objects.isNull(value) || value.isEmpty()) ? "" : value.replaceAll("[^\\d]", "");
    }

    public static String toStringLocalDateFormatadaPor(LocalDate data, String strFormato) {
        if (Objects.isNull(data))
            throw new IllegalArgumentException(MENSAGEM_VALIDACAO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(strFormato);
        return data.format(formatter);
    }

    public static String toStringLocalDateFormatada(LocalDate data) {
        return toStringLocalDateFormatadaPor(data, "dd/MM/yyyy");
    }
}
