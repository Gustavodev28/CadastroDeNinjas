package java10x.CadastroDeNinjas.Missoes;

import java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("missoes")
public class MissoesController {

   private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET - REQUISICAO PARA MOSTRAR MISSOES
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }
//POST - REQUISICAO PARA CRIAR MISSAO
    @PostMapping("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoes){
        return missoesService.criarMissao(missoes);
    }
//REQUISICAO PARA ALTERAR
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorID(@PathVariable Long id, @RequestBody MissoesDTO missaoAtuazlizada){
        return missoesService.alterarId(id, missaoAtuazlizada);
    }
//REQUISICAO PARA DELETAR
    @DeleteMapping("/deletarID/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}
