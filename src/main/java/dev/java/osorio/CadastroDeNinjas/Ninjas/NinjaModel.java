package dev.java.osorio.CadastroDeNinjas.Ninjas;

import dev.java.osorio.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    //Anotação para que um ninja apenas tenha uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key == Chave Estrangeira
    private MissoesModel missao;
}
