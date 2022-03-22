package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDto {

    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;

    private String descricao;
}
