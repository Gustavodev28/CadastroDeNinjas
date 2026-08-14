package java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public NinjaModel ninjaModel(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjas (Create)

    @GetMapping("/listar")
        public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
        }

    //Mostrar todos os ninjas por id (Read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    //Alterar dados dos ninjas (Update)
    @PutMapping("/alterar/{id}")
public NinjaModel alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado ){
        return ninjaService.alterarId(id, ninjaAtualizado);

    }
    //Deletar Ninja (Delete)
    @DeleteMapping("/deletarID/{id}")
    public void deletarNinjaId(@PathVariable Long id) {
        ninjaService.deletarNinjaId(id);
    }

}
