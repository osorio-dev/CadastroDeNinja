package dev.java.osorio.CadastroDeNinjas.Missoes;

import dev.java.osorio.CadastroDeNinjas.Enums.ResponseValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;
    @Autowired
    private MissoesMapper missoesMapper;

    //PEGA TODAS AS MISSÕES CADASTRADAS NO BANCO
    public List<MissoesDTO> getAllMissions() {
        return missoesRepository.findAll().stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //CRIAR/SALVAR UMA MISSÃO
    public ResponseValidation createMission(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesRepository.save(missoesModel);
        return ResponseValidation.SUCCESS;
    }

    //ATUALIZAR MISSAO
    public ResponseValidation updateMission(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        if (missoesModel.isEmpty()) {
            return ResponseValidation.FAILURE;
        }

        missoesDTO.setId(id);
        return createMission(missoesDTO);
    }

    //DELETAR MISSAO
    public ResponseValidation deleteMission(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        if (missoesModel.isEmpty()) {
            return ResponseValidation.FAILURE;
        }

        missoesRepository.deleteById(id);
        return ResponseValidation.SUCCESS;
    }
}
