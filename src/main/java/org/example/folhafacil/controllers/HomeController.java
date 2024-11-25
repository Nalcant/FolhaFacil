package org.example.folhafacil.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/") // Mapeia a raiz "/" como a primeira página
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao sistema!");
        return "fragments/home"; // O nome do arquivo HTML que será renderizado (index.html)
    }
}

