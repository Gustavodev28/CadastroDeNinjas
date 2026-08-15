package java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map (NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map (NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }
}
