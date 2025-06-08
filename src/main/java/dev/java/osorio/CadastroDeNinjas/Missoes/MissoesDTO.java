package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {
    private Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> listNinja;
}
