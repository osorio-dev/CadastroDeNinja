package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira Rota";
    }

    // EndPoints

    //Adicionar Ninjas (CREATE)
    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return  ninjaService.createNinja(ninja);
    }

    //Mostrar Ninjas (READ)
    @GetMapping("/allninjas")
    public List<NinjaModel> getAllNinjas() {
        return ninjaService.getAllNinjas();
    }

    //Mostrar Ninjas por ID (READ)
    //PathVariable recebe parametros do usuario
    @GetMapping("/ninja/{id}")
    public NinjaModel getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/update")
    public String updateNinja() {
        return "Alterar ninja";
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/delete")
    public String deleteNinjaId() { return "Ninja Deletado"; }

}
