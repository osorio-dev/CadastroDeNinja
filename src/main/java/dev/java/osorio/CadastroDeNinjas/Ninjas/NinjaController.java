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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return  ninjaService.createNinja(ninja);
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
    public void deleteNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }

}
