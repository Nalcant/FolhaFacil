package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Encargo;
import org.example.folhafacil.repository.EncargoRepository;
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
@RequestMapping("/encargos")
public class EncargoController {
    @Autowired
    private EncargoRepository encargoRepository;

    @GetMapping("/")
    public String submitForm(Model model) {
        var encargos = encargoRepository.findAll();
        model.addAttribute("encargos", encargos);
        return "fragments/encargos/listagem";
    }

    @GetMapping("/criar") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("encargo", new Encargo());
        return "fragments/encargos/form";
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var encargo = encargoRepository.findById(id).orElse(null);
        if (encargo == null) {
            return "redirect:/encargos/";
        }
        model.addAttribute("encargo", encargo);
        return "fragments/encargos/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var encargos = encargoRepository.findById(id).orElse(null);
        if (encargos == null) {
            return "redirect:/encargos/";
        }
        encargoRepository.delete(encargos);
        return "redirect:/encargos/";
    }

    @PostMapping("/salvar")
    public ModelAndView addEncargo(@ModelAttribute Encargo encargo, BindingResult result, ModelMap model) {
        log.info("Salvando encargo: " + encargo);
        model.addAttribute("encargo", encargo);
        try {
            encargoRepository.save(encargo);
        } catch (DataAccessException e) {
            result.rejectValue("descricao", "error.encargo", "Esse encargo já existe");
            model.addAttribute("encargo", encargo);
            return new ModelAndView("fragments/encargos/form", model);
        }
        model.addAttribute("encargo", new Encargo());
        return new ModelAndView("redirect:/encargos/", model);
    }
}
