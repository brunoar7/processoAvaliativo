package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table( name = "T_Disciplina", schema="public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long id;

    @NotBlank
    @Column(name = "NM_DISCIPLINA")
    private String nome;

    @NotBlank
    @Column(name = "SG_DISCIPLINA")
    private String sigla;

    @Column(name = "DC_DISCIPLINA")
    private String descricao;


    

}
