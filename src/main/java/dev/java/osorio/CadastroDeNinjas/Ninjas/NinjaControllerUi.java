package dev.java.osorio.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/allninjas")
    public String getAllNinjas(Model model) {
        List<NinjaDTO> ninjaDTOList = ninjaService.getAllNinjas();
        model.addAttribute("listNinja", ninjaDTOList);
        return "listarNinjas";
    }

    @GetMapping("/perfil/{id}")
    public String getNinjaById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);
        model.addAttribute("ninjaPerfil", ninja);
        return "detailsNinja";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/allninjas";
    }
}
