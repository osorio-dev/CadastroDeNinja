package dev.java.osorio.CadastroDeNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.osorio.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missao") // Importante para pegar o valor em memoria para o uso do thymeleaf
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    private String rank;

    private int age;

    //Anotação para que um ninja apenas tenha uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key == Chave Estrangeira
    private MissoesModel missao;
}
