package com.senai.escola.Service;

import com.senai.escola.Interface.UsuarioRepository;
import com.senai.escola.Models.Usuario;
import org.apache.catalina.Authenticator;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.

@Service
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.remote.JMXAuthenticator;

public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    public Usuario fazerLogin(String username, String senha) {
        return repository.findByUsernameAndSenha(username, senha).orElse(null);
    }

    public Usuario cadastrarNovoUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

}

@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody Usuario usuario) {
    try {
        Authenticator authenticationManager;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuario.getUsername(),
                        usuario.getSenha()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Busca o usuário para obter a role
        Usuario user = UsuarioService.findByUsername(usuario.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return ResponseEntity.ok("Login realizado com sucesso! Bem-vindo, " + user.getUsername() +
                " (Role: " + user.getRole() + ")");
    } catch (Exception e) {
        return ResponseEntity.status(401).body("Usuário ou senha inválidos!");
    }
}

@PostMapping("/register")

public ResponseEntity<?> register(@RequestBody Usuario usuario) {
    try {
        // Verifica se o usuário já existe
        if (usuarioService.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        Usuario novoUsuario = usuarioService.cadastrarNovoUsuario(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso: " + novoUsuario.getUsername());
    }catch (Exception e){
        return ResponseEntity.badRequest().body("Erro ao cadastrar usuário: " + e.getMessage());
    }
}