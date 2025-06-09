package dev.java.osorio.CadastroDeNinjas.Ninjas;

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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + newNinja.getName() + " criado com sucesso!!");
    }

    //Mostrar Ninjas (READ)
    @GetMapping("/allninjas")
    public List<NinjaDTO> getAllNinjas() {
        return ninjaService.getAllNinjas();
    }

    //Mostrar Ninjas por ID (READ)
    //PathVariable recebe parametros do usuario
    @GetMapping("/ninja/{id}")
    public NinjaDTO getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.updateNinja(id,ninja);
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaId(@PathVariable Long id) {
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
