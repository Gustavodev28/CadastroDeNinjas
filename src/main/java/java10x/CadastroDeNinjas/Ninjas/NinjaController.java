package java10x.CadastroDeNinjas.Ninjas;

import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public String boasVindas() {
        return "Primeira mensagem nessa rota";

    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (Id): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar todos os ninjas por id (Read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);

        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com Id: " + id + " Nao encontrado");
        }
    }

    //Alterar dados dos ninjas (Update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaDTO = ninjaService.alterarId(id, ninjaAtualizado);
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.alterarId(id, ninjaDTO);
            return ResponseEntity.ok("Ninja com Id: " + id + " Modificado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com Id: " + id + " Nao encontrado");
        }

    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarNinjaId(@PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com Id: " + id + " deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com Id: " + id + " Nao encontrado");
        }

    }
}
