package dev.java.osorio.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission") // Sub-Dominio
public class MissoesController {

    //Adicionar Missão (CREATE)
    //Post - Requisição para popular (adicionar) dados
    @PostMapping("/create")
    public String createMission(){ return "Missao Criada"; }

    //Alterar dados da Missao (UPDATE)
    //Put - Requisição para alterar dados
    @PutMapping("/update")
    public String updateMission() {
        return "Missao Alterada";
    }

    //Deletar Missao (DELETE)
    //Delete - Requisição para deletar dados
    @DeleteMapping("/delete")
    public String deleteMission() { return "Missão Deletada"; }

    //Listar Missoes (READ)
    //Get - Requisição para ler dados
    @GetMapping("/read")
    public String readMissions() {
        return "Mostrando todas as missoes";
    }
}
