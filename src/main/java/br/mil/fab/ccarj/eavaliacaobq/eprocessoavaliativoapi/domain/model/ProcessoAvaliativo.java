package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "T_PROCESSO_AVALIATIVO", schema="public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProcessoAvaliativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESSO_AVALIATIVO")
    private Long id;

    @Column(name = "NM_PROCESSO_AVALIATIVO")
    private String nome;

    @Column(name = "DC_PROCESSO_AVALIATIVO")
    private String descricao;


    @OneToMany(mappedBy = "processoAvaliativo")
    private List<ProcessoModelo> processoModelo;


    @OneToMany(mappedBy = "processoAvaliativo")
    private List<ProcessoDiscente> processoDiscente;
}
