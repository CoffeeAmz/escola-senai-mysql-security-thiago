package com.senai.escola.Service;

import com.senai.escola.Interface.UsuarioRepository;
import com.senai.escola.Models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

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
