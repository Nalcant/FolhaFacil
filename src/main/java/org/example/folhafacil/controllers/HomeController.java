package org.example.folhafacil.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Mapeia a raiz "/" como a primeira página
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao sistema!");
        return "home"; // O nome do arquivo HTML que será renderizado (home.html)
    }
}

