package dev.java.osorio.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

//Extende de JPA com parametros da classe que ele vai escanear e seu ID
//ORM Traduz nossas classes para a linguagem do banco de dados
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
