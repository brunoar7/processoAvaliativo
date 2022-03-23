package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_PROCESSO_DISCENTE", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProcessoDiscente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESSO_DISCENTE")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ID_PROCESSO_AVALIATIVO")
    private ProcessoAvaliativo processoAvaliativo;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ID_DISCENTE")
    private Discente discente;


}
