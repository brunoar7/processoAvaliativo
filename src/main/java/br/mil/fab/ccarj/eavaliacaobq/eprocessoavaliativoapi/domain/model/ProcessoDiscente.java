package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_Processo_Discente", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProcessoDiscente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESSO_DISCSCENTE")
    private Long id;

    @ManyToOne
    private Discente discente;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private List<ProcessoAvaliativo> processoAvaliativo;

}
