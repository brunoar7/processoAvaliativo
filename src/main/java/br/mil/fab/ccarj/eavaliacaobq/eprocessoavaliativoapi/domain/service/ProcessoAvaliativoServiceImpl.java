package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ProcessoAvaliativo;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository.ProcessoAvaliativoRepository;
import javassist.NotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProcessoAvaliativoServiceImpl implements  ProcessoAvaliativoService {

    private final ProcessoAvaliativoRepository repository;


    public ProcessoAvaliativoServiceImpl(ProcessoAvaliativoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProcessoAvaliativo create(ProcessoAvaliativo entity) {
        return repository.save(entity);
    }

    @Override
    public ProcessoAvaliativo findById(Long id)  {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Processo avaliativo não encontrado"));    }

    @Override
    public Page<ProcessoAvaliativo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(Long id, ProcessoAvaliativo entity)  {
        ProcessoAvaliativo processoAvaliativo =findById(id);

        ModelMapper Mapper = new ModelMapper();


        repository.save(processoAvaliativo);
    }

    @Override
    public void delete(Long id) {

    }
}
