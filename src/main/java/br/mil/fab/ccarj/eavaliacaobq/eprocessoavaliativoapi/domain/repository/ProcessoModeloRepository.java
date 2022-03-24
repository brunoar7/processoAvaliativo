package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ProcessoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoModeloRepository extends JpaRepository<ProcessoModelo, Long> {
}
