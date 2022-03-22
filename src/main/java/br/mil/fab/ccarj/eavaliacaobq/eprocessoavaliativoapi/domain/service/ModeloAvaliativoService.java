package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.dto.ModeloAvaliativoDto;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.exception.EntidadeNaoEncontradaException;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.ModeloAvaliativo;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.repository.ModeloAvaliativoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloAvaliativoService {

    @Autowired
    private ModeloAvaliativoRepository modeloAvaliativoRepository;

    @Autowired
    private ModelMapper modelMapper;



    public ModeloAvaliativoDto salvar(@Valid ModeloAvaliativoDto modeloAvaliativoDto) throws Exception {
        ModeloAvaliativo modeloAvaliativoSalva = modeloAvaliativoRepository.save(modelMapper.map(modeloAvaliativoDto, ModeloAvaliativo.class));
        return modelMapper.map(modeloAvaliativoSalva, ModeloAvaliativoDto.class);
    }

    public ModeloAvaliativoDto atualizar(Long id, ModeloAvaliativoDto modeloAvaliativoDto) throws Exception {
        Optional<ModeloAvaliativo> found = modeloAvaliativoRepository.findById(id);
        if (found.isPresent()) {
            modeloAvaliativoDto.setId(found.get().getId());
            ModeloAvaliativo map = modelMapper.map(modeloAvaliativoDto, ModeloAvaliativo.class);
            return modelMapper.map(modeloAvaliativoRepository.save(map), ModeloAvaliativoDto.class);
        } else {
            throw new Exception(String.format("Modelo inexistente"));
        }
    }

    public void remover(Long id) throws Exception {
        try {
            Optional<ModeloAvaliativo> found = modeloAvaliativoRepository.findById(id);
            if (found.isPresent()) {
                modeloAvaliativoRepository.deleteById(id);
            } else {
                throw new EntidadeNaoEncontradaException(String.format("Modelo inexistente"));
            }
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeNaoEncontradaException(String.format("Modelo inexistente!"));
        }
    }

    public List<ModeloAvaliativoDto> listarTodos() throws Exception {
        return modeloAvaliativoRepository.findAll().stream()
                .map(modeloAvaliativo ->
                        modelMapper.map(modeloAvaliativo, ModeloAvaliativoDto.class))
                .collect(Collectors.toList());
    }

    public Optional buscarPorId(Long id) throws Exception {
        Optional<ModeloAvaliativo> modeloAvaliativo = modeloAvaliativoRepository.findById(id);
        if (modeloAvaliativo.isPresent()) {
            return modelMapper.map(modeloAvaliativo, Optional.class);
        }
        return Optional.empty();
    }

}

