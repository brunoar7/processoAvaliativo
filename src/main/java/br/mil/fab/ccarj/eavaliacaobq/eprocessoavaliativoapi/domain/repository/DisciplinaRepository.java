package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
