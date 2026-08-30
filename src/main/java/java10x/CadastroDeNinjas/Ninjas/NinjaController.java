package java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mnesagem de boas vindas para quem a acessa")
    public String boasVindas() {
        return "Primeira mensagem nessa rota";

    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Usuario manda os dados do ninja a ser criado no corpo da requisicao")
            @RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (Id): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas" , description = "Lista todos os ninjas do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar todos os ninjas por id (Read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista ninja por Id", description = "Lista ninjas por id passado pelo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id) {
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
    @Operation(summary = "Altera ninja por id", description = "Altera caracteristicas dos ninjas por id passado pelo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity alterarNinjaPorID(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado) {

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
    @Operation(summary = "Deleta ninja por id",description = "Deleta ninja por id passado pelo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel deletar")
    })
    public ResponseEntity<String> deletarNinjaId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com Id: " + id + " deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com Id: " + id + " Nao encontrado");
        }

    }
}
