package dev.java.osorio.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setName(missoesDTO.getName());
        missoesModel.setDifficulty(missoesDTO.getDifficulty());
        missoesModel.setListNinja(missoesDTO.getListNinja());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setName(missoesModel.getName());
        missoesDTO.setDifficulty(missoesModel.getDifficulty());
        missoesDTO.setListNinja(missoesModel.getListNinja());

        return missoesDTO;
    }
}
