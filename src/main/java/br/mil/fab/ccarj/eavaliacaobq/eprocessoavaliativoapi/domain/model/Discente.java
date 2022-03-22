package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name ="T_DISCENTE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCENTE")
    private Long id;

    @Column(name = "NM_DISCENTE")
    private String nome;

    @Column(name = "SR_DISCENTE")
    private Long saram;

    @Column(name = "DC_DISCENTE")
    private String descricao;


}
