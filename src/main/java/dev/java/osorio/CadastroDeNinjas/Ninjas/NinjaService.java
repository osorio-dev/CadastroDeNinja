package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // @Autowired annotation para injetar dependencia
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas cadastrados
    public List<NinjaModel> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    //Pegar Ninja por ID
    public NinjaModel getNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    //Criar Ninja
    public NinjaModel createNinja(NinjaModel ninja) {
         return ninjaRepository.save(ninja);
    }

}
