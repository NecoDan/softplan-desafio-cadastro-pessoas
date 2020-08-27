package br.com.softplan.api.rest.service.pessoas.model;

import br.com.softplan.api.rest.service.pessoas.util.domain.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@ToString
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sp01_pessoa", schema = "softplan_services")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    @Tolerate
    public Pessoa() {
        super();
    }

    @Size(max = 300, message = "Qtde de caracteres do NOME ultrapassa o valor permitido igual à 300.")
    @NotBlank(message = "Nome inválido! Insira uma NOME válido para a pessoa.")
    @NotNull(message = "Nome inválido! Insira uma NOME válido para a pessoa.")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 11, message = "Qtde de caracteres do CPF ultrapassa o valor permitido igual à 11.")
    @CPF
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @PastOrPresent(message = "Data de nascimento vazia e/ou inválida! Insira uma data de nascimento válida para a pessoa.")
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sexo")
    private TipoSexo tipoSexo;

    @Column(name = "email", nullable = false)
    @Email(message = "Email inválido! Insira um valor de email válido.")
    private String email;

    @Size(max = 200, message = "Naturalidade inválida! Qtde de caracteres da Naturalidade ultrapassa o valor permitido igual à 200.")
    @Column(name = "naturalidade")
    private String naturalidade;

    @Size(max = 200, message = "Nacionalidade inválida! Qtde de caracteres da Nacionalidade ultrapassa o valor permitido igual à 200.")
    @Column(name = "nacionalidade")
    private String nacionalidade;

    @JsonIgnore
    @Transient
    private String conteudoJson;

}
