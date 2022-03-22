package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.api.controller;


import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.dto.ModeloAvaliativoDto;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service.ModeloAvaliativoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelo-avaliativo")
@Api("Modelo-Avaliativo")
public class ModeloAvaliativoController {

    @Autowired
    private ModeloAvaliativoService modeloAvaliativoService;

    @ApiOperation(value = "Cadastrar Modelo Avaliativo", nickname = "cadastrarModeloAvaliativo", notes = "Cadastra Modelo Avaliativo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})


    @PostMapping
    @ResponseBody
    public ResponseEntity<ModeloAvaliativoDto> salvar(@RequestBody @Valid ModeloAvaliativoDto modeloAvaliativoDto)
            throws Exception {
        try {
            modeloAvaliativoService.salvar(modeloAvaliativoDto);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            throw new Exception(e);

        }
    }

    @ApiOperation(value = "Atualizar Modelo Avaliativo ", nickname = "atualizarModeloAvaliativo", notes = "Atualizar Modelo")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @PutMapping("/{id}")
    public ResponseEntity<ModeloAvaliativoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ModeloAvaliativoDto modeloAvaliativoDto)
            throws Exception {
        try {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @ApiOperation(value = "Excluir Modelo Avaliativo ", nickname = "excluirModeloAvaliativo", notes = "Excluir Modelo Avaliativo")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<ModeloAvaliativoDto> remover(@PathVariable(name = "id") Long id) throws Exception {                            //Path variable é pra coonseguir pegar pelo id
        modeloAvaliativoService.remover(id);
        return ResponseEntity.noContent().build();

    }

    @ApiOperation(value = "Listar Modelo Avaliativo ", nickname = "listarModeloAvaliativo", notes = "Listar Modelo Avaliativo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})
    @GetMapping()
    public ResponseEntity<List<ModeloAvaliativoDto>> listarTodos() throws Exception {
        return ResponseEntity.ok(modeloAvaliativoService.listarTodos());
    }

    @ApiOperation(value = " Buscar ", nickname = "Buscar", notes = "Buscar")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<ModeloAvaliativoDto>> buscar(@PathVariable(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(modeloAvaliativoService.buscarPorId(id));
    }

}