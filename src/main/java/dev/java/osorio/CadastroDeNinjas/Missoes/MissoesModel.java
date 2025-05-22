package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private MissionRanks difficulty;

    // Anotação para que a missao receba varios ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> listNinja;
}
