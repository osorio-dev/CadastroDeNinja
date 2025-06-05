package dev.java.osorio.CadastroDeNinjas.Ninjas;

import dev.java.osorio.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Tirar Responsabilidade do Model Trabalhar Logica emcima do DTO sem expor o Model
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private MissoesModel missao;
    private String rank;
}
