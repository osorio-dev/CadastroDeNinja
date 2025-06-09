package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    // @Autowired annotation para injetar dependencia
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas cadastrados
    public List<NinjaDTO> getAllNinjas() {
        List<NinjaModel> ninjaModelList = ninjaRepository.findAll();

        return ninjaModelList.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Pegar Ninja por ID
    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninjaModelById = ninjaRepository.findById(id);
        return ninjaModelById.map(ninjaMapper::map).orElse(null);

    }

    //Criar Ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Deletar ninja
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Atualizar um Ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);

        //Condição pra saber se existe ou não o ID com (Fail Fast)
        if (ninjaModel.isEmpty()) {
            return null;
        }

        ninjaDTO.setId(id);

        return createNinja(ninjaDTO);
    }

}
