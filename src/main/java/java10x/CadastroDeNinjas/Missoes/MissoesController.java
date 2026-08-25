package java10x.CadastroDeNinjas.Missoes;

import java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoesDTO = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO ninjaDTO = missoesService.listarMissaoPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com Id: " + id + " Nao encontrado");
        }
    }
//POST - REQUISICAO PARA CRIAR MISSAO
    @PostMapping("/criar")
    public ResponseEntity criarMissoes(@RequestBody MissoesDTO missoes){
        MissoesDTO missoesDTO = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao: " + missoesDTO.getNomeDaMissao() + " , Criada com sucesso");
    }
//REQUISICAO PARA ALTERAR
    @PutMapping("/alterar/{id}")
    public ResponseEntity alterarMissaoPorID(@PathVariable Long id, @RequestBody MissoesDTO missaoAtuazlizada){
        MissoesDTO missoesDTO = missoesService.alterarId(id, missaoAtuazlizada);
        if (missoesDTO != null){
            missoesService.alterarId(id, missoesDTO);
            return ResponseEntity.ok("Missao com Id: " + id + " Modificado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com Id: " + id + " Nao encontrado");
        }

    }
//REQUISICAO PARA DELETAR
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
       if (missoesService.listarMissaoPorId(id) != null){
           missoesService.deletarMissaoPorId(id);
           return ResponseEntity.ok("Missao com Id: " + id + " deletado com sucesso");

       }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Missao com Id: " + id + " Nao encontrado");
       }

    }

}
