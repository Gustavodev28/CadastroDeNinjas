package java10x.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinja";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaId(@PathVariable("id") Long id) {
        ninjaService.deletarNinjaId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/detalhes/{id}")
    public String listarNinjasPorId(@PathVariable("id") Long id, Model model) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);

        if (ninjaDTO != null) {
            model.addAttribute("ninja", ninjaDTO);
            return "detalhesNinja";

        } else {
            model.addAttribute("mensagem", "Ninja nao encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }
}