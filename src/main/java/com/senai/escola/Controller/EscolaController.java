package com.senai.escola.Controller;

import com.senai.escola.Models.Escola;
import com.senai.escola.Service.EscolaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    private final EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping
    public List<Escola> buscarEscolas(){
        return escolaService.buscarEscolas();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public Escola salvar(@RequestBody Escola escola){
        return escolaService.salvarNovoEscola(escola);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public void excluirEscola(@PathVariable Long id){
        escolaService.deletarEscola(id);
    }

    @PreAuthorize("hasRole('admin', 'professor')")
    @GetMapping("/{id}")
    public Escola buscaEscolaPorId(@PathVariable Long id){
        return escolaService.buscarEscolaId(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/{id}")
    public Escola atualizarEscola(@PathVariable Long id, @RequestBody Escola novaEscola){

        Escola verificaEscola = escolaService.buscarEscolaId(id);
        if (verificaEscola == null) return null;

        verificaEscola.setNome(novaEscola.getNome());
        verificaEscola.setEmail(novaEscola.getEmail());
        verificaEscola.setTelefone(novaEscola.getTelefone());
        //verificaEscola.setCnpj(novaEscola.getCnpj());
        verificaEscola.setComponentes(novaEscola.getComponentes());
        verificaEscola.setTurmas(novaEscola.getTurmas());
        verificaEscola.setStatusAluno(novaEscola.getStatusAluno());

        return escolaService.salvarNovoEscola(verificaEscola);
    }
}
