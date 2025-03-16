package net.javaguides.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "index"; // Assuming 'index.html' is under 'src/main/resources/templates'
    }
}
