package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Cargo;
import org.example.folhafacil.models.Departamento;
import org.example.folhafacil.models.Usuario;
import org.example.folhafacil.repository.CargoRepository;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/")
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
    public ModelAndView addCargo(@ModelAttribute Cargo cargo, BindingResult result, ModelMap model) {
        log.info("Salvando departamento: " + cargo);
        model.addAttribute("cargo", cargo);
        try {
            cargoRepository.save(cargo);
        } catch (DataAccessException e) {
            result.rejectValue("descricao", "error.login", "Esse departamento já existe");
            model.addAttribute("cargo", cargo);
            return new ModelAndView("fragments/cargos/form", model);
        }
        model.addAttribute("departamento", new Departamento());
        return new ModelAndView("redirect:/cargos/", model);
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var cargo = cargoRepository.findById(id).orElse(null);
        if (cargo == null) {
            return "redirect:/cargos/";
        }
        model.addAttribute("cargo", cargo);
        return "fragments/cargos/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var cargo = cargoRepository.findById(id).orElse(null);
        if (cargo == null) {
            return "redirect:/cargos/";
        }
        cargoRepository.delete(cargo);
        return "redirect:/cargos/";
    }
}
