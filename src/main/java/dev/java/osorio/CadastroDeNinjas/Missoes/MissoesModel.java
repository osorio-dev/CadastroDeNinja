package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionRanks difficulty;

    // Anotação para que a missao receba varios ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> listNinja;

    public MissoesModel() {
    }

    public MissoesModel(String name, MissionRanks difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionRanks getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(MissionRanks difficulty) {
        this.difficulty = difficulty;
    }
}
