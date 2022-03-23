package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table( name = "T_MODELO_AVALIATIVO", schema="public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModeloAvaliativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODELO_AVALIATIVO")
    private Long id;

    @NotBlank
    @Column(name = "NM_MODELO_AVALIATIVO")
    private String nome;

    @NotBlank
    @Column(name = "SG_MODELO_AVALIATIVO")
    private String sigla;

    @Column(name = "DC_MODELO_AVALIATIVO")
    private String descricao;



}
