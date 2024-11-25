package org.example.folhafacil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Cargo;
import org.example.folhafacil.models.Departamento;
import org.example.folhafacil.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/listar")
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


    @PostMapping("/salvar")
    public String addUsuario(@ModelAttribute Departamento departamento, Model model) {
        log.info("Salvando departamento: " + departamento);
        departamentoRepository.save(departamento);
        // Retorna o fragmento atualizado
        model.addAttribute("departamento", new Departamento());
        return "fragments/departamentos/form";
    }
}
