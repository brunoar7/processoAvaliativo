package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.Discente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscenteRepository  extends JpaRepository<Discente, Long> {
}
