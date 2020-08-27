package br.com.softplan.api.rest.service.pessoas.model.dominio;

import br.com.softplan.api.rest.service.pessoas.model.enums.TipoSexo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TipoSexoConverter implements AttributeConverter<TipoSexo, String> {

    @Override
    public String convertToDatabaseColumn(TipoSexo tipoSexo) {
        if (tipoSexo == null)
            return null;
        return tipoSexo.getCodigo();
    }

    @Override
    public TipoSexo convertToEntityAttribute(String codigo) {
        if (codigo == null)
            return null;
        return Stream.of(TipoSexo.values()).filter(c -> c.getCodigo().equals(codigo)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
