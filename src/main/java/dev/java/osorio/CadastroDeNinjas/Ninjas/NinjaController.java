package dev.java.osorio.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // EndPoints

    //Adicionar Ninjas (CREATE)
    @PostMapping("/create")
    @Operation(summary = "Cria um Novo Ninja", description = "Esta Rota Cria um Novo Ninja e Insere ele no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro na Criação do Ninja!!")
    })
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + newNinja.getName() + " criado com sucesso!!");
    }

    //Mostrar Ninjas (READ)
    @GetMapping("/allninjas")
    @Operation(summary = "Lista Todos os Ninjas", description = "Esta Rota Lista todos os Ninjas cadastrados no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro Ninja não Encontrado!!")
    })
    public List<NinjaDTO> getAllNinjas() {
        return ninjaService.getAllNinjas();
    }

    //Mostrar Ninjas por ID (READ)
    //PathVariable recebe parametros do usuario
    @GetMapping("/ninja/{id}")
    @Operation(summary = "Lista o Ninjda por ID", description = "Esta Rota Lista um Ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não Encontrado!!")
    })
    public NinjaDTO getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza um Ninja", description = "Esta Rota Atualiza um Ninja no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Atualizado com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro ao Atualizar o Ninja!!")
    })
    public NinjaDTO updateNinja(
            @Parameter(description = "Usuário envia o ID na rota da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário envia os dados do ninja que deseja atualizar no corpo da requisição")
            @RequestBody NinjaDTO ninja
    ) {
        return ninjaService.updateNinja(id,ninja);
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Apaga um Ninja", description = "Esta Rota Deleta um Ninja no Banco De Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Apagado com Sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Erro ao Deletar o Ninja!!")
    })
    public ResponseEntity<String> deleteNinjaId(
            @Parameter(description = "Usuario envia o ID na rota da requisição")
            @PathVariable Long id
    ) {
        NinjaDTO findNinja = ninjaService.getNinjaById(id);

        if (findNinja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não Existe um ninja associado a este ID");
        }

        ninjaService.deleteNinja(findNinja.getId());

        return ResponseEntity.status(HttpStatus.OK)
                .body("O ninja " + findNinja.getName() + " foi Excluido com sucesso!!");
    }

}
