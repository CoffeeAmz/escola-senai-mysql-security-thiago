package com.senai.escola.Controller;

import com.senai.escola.Models.Usuario;
import com.senai.escola.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // Permite chamadas do frontend
public class AuthController {

    private final UsuarioService usuarioService;
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario user = usuarioService.fazerLogin(usuario.getUsername(), usuario.getSenha());

        if (user != null) {
            return "Login realizado com sucesso! Bem-vindo, " + user.getUsername();
        }
        return "Usuário ou senha inválidos!";
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Usuario usuario) { //register = cadastrar
        try {
            // verifica se o usuário já existe
            if (usuarioService.findByUsername(usuario.getUsername().isPresent)){
                return ResponseEntity.badRequest().body("Usuário já existe!");

            }
            Usuario novoUsuario = usuarioService.cadastrarNovousuario(usuario);
        }
    }


}
