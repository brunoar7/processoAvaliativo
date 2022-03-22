package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "T_PROCESSO_MODELO", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProcessoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESSO_MODELO")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private ModeloAvaliativo modeloAvaliativo;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ID_PROCESSO_AVALIATIVO", referencedColumnName = "ID_PROCESSO_AVALIATIVO")
    private ProcessoAvaliativo processoAvaliativo;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ID_DISCIPLINA", referencedColumnName = "ID_DISCIPLINA")
    private Disciplina disciplina;


}
