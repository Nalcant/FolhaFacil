package org.example.folhafacil.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Salario;
import org.example.folhafacil.models.Usuario;
import org.example.folhafacil.repository.BeneficioRepository;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.EncargoRepository;
import org.example.folhafacil.repository.SalarioRepository;
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
@RequestMapping("/salarios")
public class SalarioController {

    @Autowired
    private SalarioRepository salarioRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private EncargoRepository encargoRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;

    @GetMapping("/criar")
    public String showForm(Model model) {
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        model.addAttribute("salario", new Salario());
        model.addAttribute("beneficios", beneficioRepository.findAll());
        model.addAttribute("encargos", encargoRepository.findAll());
        return "fragments/salarios/form";
    }

    //listagem de todos os usuários
    @GetMapping("/")
    public String submitForm(Model model) {
        Iterable<Salario> salarios = salarioRepository.findAll();
        model.addAttribute("salarios", salarios);
        return "fragments/salarios/listagem";
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        Salario salario = salarioRepository.findById(id).orElse(null);
        if (salario == null) {
            return "redirect:/salarios/";
        }
        model.addAttribute("salario", salario);
        return "fragments/salario/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        Salario salario = salarioRepository.findById(id).orElse(null);
        if (salario == null) {
            return "redirect:/salarios/";
        }
        salarioRepository.delete(salario);
        return "redirect:/salarios/";
    }


    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Salario salario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("salario", salario);
            return new ModelAndView("fragments/salarios/form", model);
        }
        log.info("Salvando salario:" + salario);
        try {
            salarioRepository.save(salario);
        } catch (DataAccessException e) {
            result.rejectValue("login", "error.login", "Esse login já está em uso");
            model.addAttribute("salario", salario);
            return new ModelAndView("fragments/salarios/form", model);
        }

        // Retorna o fragmento atualizado
        model.addAttribute("salario", salario);
        return new ModelAndView("redirect:/salarios/", model); // Fragmento renderizado
    }
}
