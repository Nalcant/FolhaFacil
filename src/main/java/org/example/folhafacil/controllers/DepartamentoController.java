package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Departamento;
import org.example.folhafacil.repository.DepartamentoRepository;
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
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/")
    public String submitForm(Model model) {
        var departamentos = departamentoRepository.findAll();
        model.addAttribute("departamentos", departamentos);
        return "fragments/departamentos/listagem";
    }

    @GetMapping("/criar") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "fragments/departamentos/form";
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento == null) {
            return "redirect:/departamentos/";
        }
        model.addAttribute("departamento", departamento);
        return "fragments/departamentos/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento == null) {
            return "redirect:/departamentos/";
        }
        departamentoRepository.delete(departamento);
        return "redirect:/departamentos/";
    }


    @PostMapping("/salvar")
    public ModelAndView addDepartamento(@ModelAttribute Departamento departamento, BindingResult result, ModelMap model) {
        log.info("Salvando departamento: " + departamento);
        model.addAttribute("departamento", departamento);
        try {
            departamentoRepository.save(departamento);
        } catch (DataAccessException e) {
            result.rejectValue("descricao", "error.login", "Esse departamento já existe");
            model.addAttribute("departamento", departamento);
            return new ModelAndView("fragments/departamentos/form", model);
        }
        model.addAttribute("departamento", new Departamento());
        return new ModelAndView("redirect:/departamentos/", model);
    }
}
