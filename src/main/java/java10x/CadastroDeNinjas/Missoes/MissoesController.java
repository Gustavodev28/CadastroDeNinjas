package java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("missoes")
public class MissoesController {

    //GET - REQUISICAO PARA MOSTRAR MISSOES
    @GetMapping
    public String mostratMissoes(){
        return "Missoes listadas com sucesso";
    }
//POST - REQUISICAO PARA CRIAR MISSAO
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missao criada com sucesso ";
    }
//REQUISICAO PARA ALTERAR
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }
//REQUISICAO PARA DELETAR
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}
