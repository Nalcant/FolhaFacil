package org.example.folhafacil.controllers;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Colaborador;
import org.example.folhafacil.repository.CargoRepository;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.DepartamentoRepository;
import org.example.folhafacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ColaboradorRepository colaboradorRepository;
    @Autowired
    CargoRepository cargoRepository;
    @Autowired
    DepartamentoRepository departamentoRepository;


    @GetMapping("/criar")
    public String showForm(Model model) {
        model.addAttribute("cargos", cargoRepository.findAll());
        model.addAttribute("departamentos", departamentoRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("colaborador", new Colaborador());
        return "fragments/colaboradores/form";
    }

    @GetMapping("/")
    public String listar(ModelMap model) {
        var colaboradores = colaboradorRepository.findAll();
        model.addAttribute("colaboradores", colaboradores);
        return "fragments/colaboradores/listagem";

    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Colaborador colaborador, ModelMap model) {
        log.info("Salvando colaborador: " + colaborador);
        colaboradorRepository.save(colaborador);
        // Retorna o fragmento atualizado
        model.addAttribute("colaborador",colaborador);
        return new ModelAndView("redirect:/colaboradores/", model); // Fragmento renderizado
    }
}

