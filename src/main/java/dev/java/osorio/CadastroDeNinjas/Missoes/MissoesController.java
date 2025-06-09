package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Enums.ResponseValidation;
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
    public ResponseEntity<List<MissoesDTO>> getAllMissions() {
        List<MissoesDTO> missoesDTOList = missoesService.getAllMissions();

        return ResponseEntity.ok(missoesDTOList);
    }

    //Adicionar Missão (CREATE)
    //Post - Requisição para popular (adicionar) dados
    @PostMapping("/create")
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
    public ResponseEntity<String> updateMission(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
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
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
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
