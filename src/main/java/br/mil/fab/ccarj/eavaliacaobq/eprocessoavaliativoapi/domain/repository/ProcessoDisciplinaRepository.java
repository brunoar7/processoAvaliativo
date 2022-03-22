package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ProcessoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoDisciplinaRepository extends JpaRepository<ProcessoModelo, Long> {
}
