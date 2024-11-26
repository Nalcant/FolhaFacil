package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Beneficio;
import org.example.folhafacil.repository.BeneficioRepository;
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
@RequestMapping("/beneficios")
public class BeneficioController {
    @Autowired
    private BeneficioRepository beneficioRepository;

    @GetMapping("/")
    public String submitForm(Model model) {
        var beneficios = beneficioRepository.findAll();
        model.addAttribute("beneficios", beneficios);
        return "fragments/beneficios/listagem";
    }

    @GetMapping("/criar") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("beneficio", new Beneficio());
        return "fragments/beneficios/form";
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var beneficios = beneficioRepository.findById(id).orElse(null);
        if (beneficios == null) {
            return "redirect:/beneficios/";
        }
        model.addAttribute("beneficios", beneficios);
        return "fragments/beneficios/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var beneficio = beneficioRepository.findById(id).orElse(null);
        if (beneficio == null) {
            return "redirect:/beneficios/";
        }
        beneficioRepository.delete(beneficio);
        return "redirect:/beneficios/";
    }

    @PostMapping("/salvar")
    public ModelAndView addBeneficio(@ModelAttribute Beneficio beneficio, BindingResult result, ModelMap model) {
        log.info("Salvando beneficio: " + beneficio);
        model.addAttribute("beneficio", beneficio);
        try {
            beneficioRepository.save(beneficio);
        } catch (DataAccessException e) {
            result.rejectValue("descricao", "error.beneficio", "Esse beneficio já existe");
            model.addAttribute("beneficio", beneficio);
            return new ModelAndView("fragments/beneficios/form", model);
        }
        model.addAttribute("beneficio", new Beneficio());
        return new ModelAndView("redirect:/beneficios/", model);
    }

}
