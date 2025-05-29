package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

}
