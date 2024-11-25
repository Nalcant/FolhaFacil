package org.example.folhafacil.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.folhafacil.models.Colaborador;
import org.example.folhafacil.models.Usuario;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.UsuarioRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.ObjectName;
import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/criar")
    public String showForm(Model model) {
        // Adicionar o objeto colaborador ao modelo
        model.addAttribute("usuario", new Usuario());
        return "fragments/usuarios/form";
    }

    //listagem de todos os usuários
    @GetMapping("/")
    public String submitForm(Model model) {
        var usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "fragments/usuarios/listagem";
    }

    @GetMapping("/{id}/")
    public String editForm(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/usuarios/";
        }
        model.addAttribute("usuario", usuario);
        return "fragments/usuarios/form";
    }

    @GetMapping("/{id}/excluir")
    public String destroy(@PathVariable(required = true, name = "id") long id, Model model) {
        // Adicionar o objeto colaborador ao modelo
        var usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/usuarios/";
        }
        usuarioRepository.delete(usuario);
        return "redirect:/usuarios/";
    }


    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return new ModelAndView("fragments/usuarios/form", model);
        }
        log.info("Salvando usuario:" + usuario);
        try {
            usuarioRepository.save(usuario);
        } catch (DataAccessException e) {
            result.rejectValue("login", "error.login", "Esse login já está em uso");
            model.addAttribute("usuario", usuario);
            return new ModelAndView("fragments/usuarios/form", model);
        }

        // Retorna o fragmento atualizado
        model.addAttribute("usuario", usuario);
        return new ModelAndView("redirect:/usuarios/", model); // Fragmento renderizado
    }
}