package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.dto.DisciplinaDto;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.exception.EntidadeNaoEncontradaException;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.Disciplina;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DisciplinaDto salvar(@Valid DisciplinaDto disciplinaDto) throws Exception {
        Disciplina disciplinaSalva = disciplinaRepository.save(modelMapper.map(disciplinaDto, Disciplina.class));
        return modelMapper.map(disciplinaSalva, DisciplinaDto.class);
    }

    public DisciplinaDto atualizar(Long id, DisciplinaDto disciplinaDto) throws Exception {
        Optional<Disciplina> found = disciplinaRepository.findById(id);
        if (found.isPresent()) {
            disciplinaDto.setId(found.get().getId());
            Disciplina map = modelMapper.map(disciplinaDto, Disciplina.class);
            return modelMapper.map(disciplinaRepository.save(map), DisciplinaDto.class);
        } else {
            throw new Exception(String.format("Disciplina inexistente"));
        }
    }

    public void remover(Long id) throws Exception {
        try {
            Optional<Disciplina> found = disciplinaRepository.findById(id);
            if (found.isPresent()) {
                disciplinaRepository.deleteById(id);
            } else {
                throw new EntidadeNaoEncontradaException(String.format("Disciplina inexistente"));
            }
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeNaoEncontradaException(String.format("Disciplina inexistente!"));
        }
    }

    public List<DisciplinaDto> listarTodos() throws Exception {
        return disciplinaRepository.findAll().stream()
                .map(disciplina ->
                        modelMapper.map(disciplina, DisciplinaDto.class))
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaDto> buscarPorId(Long id) throws Exception {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isPresent()) {
            return modelMapper.map(disciplina, Optional.class);
        }
        return Optional.empty();
    }

}
