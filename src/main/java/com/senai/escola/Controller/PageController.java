package com.senai.escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/login.html")
    public String login() {
        return "forward:/static/login.html";
    }

    @GetMapping("/aluno.html")
    public String aluno() {
        return "forward:/static/aluno.html";

    }@GetMapping("/escola.html")
    public String escola() {
        return "forward:/static/escola.html";

    }@GetMapping("/professor.html")
    public String professor() {
        return "forward:/static/professor.html";
    }
}
