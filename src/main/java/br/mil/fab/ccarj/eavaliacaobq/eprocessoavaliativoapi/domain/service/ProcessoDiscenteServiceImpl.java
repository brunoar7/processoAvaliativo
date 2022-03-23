package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;


import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ProcessoDiscente;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository.ProcessoDiscenteRepository;
import javassist.NotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProcessoDiscenteServiceImpl implements  ProcessoDiscenteService {

    private final ProcessoDiscenteRepository repository;

    public ProcessoDiscenteServiceImpl(ProcessoDiscenteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProcessoDiscente create(ProcessoDiscente entity) {
        return repository.save(entity);
    }

    @Override
    public ProcessoDiscente findById(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(()-> new ("Pocesso<->Discente não encontrado"));
    }

    @Override
    public Page<ProcessoDiscente> findAll(Pageable pageable) {
        return repository.findAll(pageable);


    }

    @Override
    public void update(Long id, ProcessoDiscente entity) {
        ProcessoDiscente processoDiscente = findById(id);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(entity, processoDiscente);

        repository.save(processoDiscente);

    }

    @Override
    public void delete(Long id) {
        ProcessoDiscente processoDiscente = findById(id);
        repository.delete(processoDiscente);
    }
}