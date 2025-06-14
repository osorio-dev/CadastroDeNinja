package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Enums.ResponseValidation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission") // Sub-Dominio
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    //Listar Missoes (READ)
    //Get - Requisição para ler dados
    @GetMapping("/allmissions")
    @Operation(summary = "Lista Todas as Missões", description = "Esta Rota Lista Todas as Missões cadastradas no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão Encontrada!!"),
            @ApiResponse(responseCode = "400", description = "Missão não Existe!!")
    })
    public ResponseEntity<List<MissoesDTO>> getAllMissions() {
        List<MissoesDTO> missoesDTOList = missoesService.getAllMissions();

        return ResponseEntity.ok(missoesDTOList);
    }

    //Adicionar Missão (CREATE)
    //Post - Requisição para popular (adicionar) dados
    @PostMapping("/create")
    @Operation(summary = "Cria uma Nova Missão", description = "Esta Rota Cria uma Nova Missão e Insere ela no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão Criada com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro na Criação da Missão!!")
    })
    public ResponseEntity<String> createMission(@RequestBody MissoesDTO missoesDTO){
        ResponseValidation responseValidation = missoesService.createMission(missoesDTO);

        return switch (responseValidation) {
            case SUCCESS: {
                yield ResponseEntity.status(HttpStatus.CREATED)
                        .body("A Missão " + missoesDTO.getName() + " Criada com Sucesso!!");
            }

            case FAILURE: {
                yield ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("A Missão nao foi criada. Erro de Servidor!!!");
            }
        };
    }

    //Alterar dados da Missao (UPDATE)
    //Put - Requisição para alterar dados
    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza uma Missão", description = "Esta Rota Atualiza uma Missão no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão Atualizada com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro ao Atualizar a Missão!!")
    })
    public ResponseEntity<String> updateMission(
            @Parameter(description = "Usuário envia o ID na rota da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário envia os dados da missão que deseja atualizar no corpo da requisição")
            @RequestBody MissoesDTO missoesDTO
    ) {
        ResponseValidation responseValidation = missoesService.updateMission(id, missoesDTO);

        return switch (responseValidation) {
            case SUCCESS: {
                yield ResponseEntity.status(HttpStatus.CREATED)
                        .body("A Missão " + missoesDTO.getName() + " Foi Alterada com Sucesso!!");
            }

            case FAILURE: {
                yield ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Não foi Possivel Alterar a Missão pois o ID passado não existe!!!");
            }
        };
    }

    //Deletar Missao (DELETE)
    //Delete - Requisição para deletar dados
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Apaga uma Missão", description = "Esta Rota Deleta uma Missão no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão Apagada com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro ao Deletar a Missão!!")
    })
    public ResponseEntity<String> deleteMission(
            @Parameter(description = "Usuario envia o ID na rota da requisição")
            @PathVariable Long id
    ) {
        ResponseValidation responseValidation = missoesService.deleteMission(id);

        return switch (responseValidation) {
            case SUCCESS: {
                yield ResponseEntity.status(HttpStatus.CREATED)
                        .body("A Missão foi Deletada com Sucesso!!");
            }

            case FAILURE: {
                yield ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Não foi Possivel deletar a Missão pois o ID passado não existe!!!");
            }
        };
    }
}
