package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira Rota";
    }

    // EndPoints

    //Adicionar Ninjas (CREATE)
    @PostMapping("/create")
    public String createNinja(){ return "Ninja Criado"; }

    //Mostrar Ninjas (READ)
    @GetMapping("/read")
    public String readNinjas() {
        return "Mostrando todos os ninjas";
    }

    //Mostrar Ninjas por ID (READ)
    @GetMapping("/readninjaid")
    public String readNinjasId() {
        return "Mostrando todos os ninjas com o ID correspondente";
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
