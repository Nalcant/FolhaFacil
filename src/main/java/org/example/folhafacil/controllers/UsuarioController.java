package org.example.folhafacil.controllers;

import org.example.folhafacil.models.Usuario;
import org.example.folhafacil.repository.ColaboradorRepository;
import org.example.folhafacil.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping("/usuario-form") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "usuario-form"; // nome do arquivo html a ser buscado
    }

    //listagem de todos os usuários
    @GetMapping("/usuarios-listagem")
    public String submitForm(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "userView";
    }

    //cadastro para novos usuários
    @PostMapping("/add-usuario")
    public String addUsuario(@ModelAttribute Usuario usuario) {
        return "redirect:/usuario-form";
    }
}