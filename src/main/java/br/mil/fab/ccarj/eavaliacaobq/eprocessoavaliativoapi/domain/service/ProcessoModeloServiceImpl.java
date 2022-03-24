package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ProcessoModelo;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository.ProcessoModeloRepository;
import javassist.NotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProcessoModeloServiceImpl implements ProcessoModeloService {

    private final ProcessoModeloRepository repository;

    public ProcessoModeloServiceImpl(ProcessoModeloRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProcessoModelo create(ProcessoModelo entity) {
        return repository.save(entity);
    }

    @Override
    public ProcessoModelo findById(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Processo Modelo não encontrado"));

    }

    @Override
    public Page<ProcessoModelo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(Long id, ProcessoModelo entity) throws NotFoundException {
        ProcessoModelo processoModelo = findById(id);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(entity, processoModelo);

        repository.save(processoModelo);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        ProcessoModelo processoModelo = findById(id);
        repository.delete(processoModelo);
    }
}
