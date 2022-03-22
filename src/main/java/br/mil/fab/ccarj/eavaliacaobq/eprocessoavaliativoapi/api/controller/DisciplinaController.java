package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.api.controller;

import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.dto.DisciplinaDto;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.model.Disciplina;
import br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service.DisciplinaService;
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
@RequestMapping("/disciplina")
@Api("Disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @ApiOperation(value = "Cadastrar disciplina", nickname = "cadastrarDisciplina", notes = "Cadastra Disciplina")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @PostMapping
    @ResponseBody
    public ResponseEntity<DisciplinaDto> salvar(@RequestBody @Valid DisciplinaDto disciplinaDto)
            throws Exception {
        try {
            disciplinaService.salvar(disciplinaDto);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            throw new Exception(e);

        }
    }

    @ApiOperation(value = "Atualizar disciplina ", nickname = "atualizarDisciplina", notes = "Atualizar Disciplina")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody @Valid DisciplinaDto disciplinaDto)
            throws Exception {
        try {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @ApiOperation(value = "Excluir disciplinas ", nickname = "excluirDisciplina", notes = "Excluir Disciplina")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<DisciplinaDto> remover(@PathVariable(name = "id") Long id) throws Exception {                            //Path variable é pra coonseguir pegar pelo id
        disciplinaService.remover(id);
        return ResponseEntity.noContent().build();

    }

    @ApiOperation(value = "Listar disciplinas ", nickname = "listarDisciplinas", notes = "Listar Disciplinas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})
    @GetMapping()
    public ResponseEntity<List<DisciplinaDto>> listarTodos() throws Exception {
        return ResponseEntity.ok(disciplinaService.listarTodos());
    }

    @ApiOperation(value = " Buscar ", nickname = "Buscar", notes = "Buscar")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<DisciplinaDto>> buscar(@PathVariable(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(disciplinaService.buscarPorId(id));
    }

}


