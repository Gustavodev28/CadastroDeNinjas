package java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Primeira mensagem nessa rota";

    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas (Create)

    @GetMapping("/listar")
        public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
        }

    //Mostrar todos os ninjas por id (Read)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninjas por ID";
    }

    //Alterar dados dos ninjas (Update)
    @PutMapping("/alterarID")
public String alterarNinjaPorID(){
        return "Alterar Ninja por ID";

    }
    //Deletar Ninja (Delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }

}
