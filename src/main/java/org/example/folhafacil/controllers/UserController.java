package org.example.folhafacil.controllers;

import org.example.folhafacil.repository.UserRepository;
import org.example.folhafacil.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userForm") //rota para a página
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm"; // nome do arquivo html a ser buscado
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "result";
    }
}