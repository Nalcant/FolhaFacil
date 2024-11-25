package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Cargo;
import org.example.folhafacil.models.Usuario;
import org.example.folhafacil.repository.CargoRepository;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/listar")
    public String submitForm(Model model) {
        var cargos =  cargoRepository.findAll();
        model.addAttribute("cargos", cargos);
        return "fragments/cargos/listagem";
    }

    @GetMapping("/criar") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "fragments/cargos/form";
    }


    @PostMapping("/salvar")
    public String addUsuario(@ModelAttribute Cargo cargo, Model model) {
        log.info("Salvando cargo: " + cargo);
        cargoRepository.save(cargo);
        // Retorna o fragmento atualizado
        model.addAttribute("cargo", new Cargo());
        return "fragments/cargos/form";
    }

}
