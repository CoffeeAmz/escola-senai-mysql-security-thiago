package com.senai.escola.Controller;

import com.senai.escola.Models.Aluno;
import com.senai.escola.Service.AlunoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    // Admin e Professor podem ver todos os alunos
    @PreAuthorize("hasAnyRole('admin', 'professor')")
    @GetMapping
    public List<Aluno> buscarAlunos(){
        return alunoService.buscarTodosAlunos();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvarNovoAluno(aluno);
    }


    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }


    @PreAuthorize("hasAnyRole('admin', 'professor')")
    @GetMapping("/{id}")
    public Aluno buscaAlunoPorId(@PathVariable Long id){
        return alunoService.buscarAlunoId(id);
    }



    @PreAuthorize("hasRole('admin')")
    @PutMapping("/{id}")
    public Aluno atualizarProfessores(@PathVariable Long id, @RequestBody Aluno novoAluno){

        Aluno verificaAluno = alunoService.buscarAlunoId(id);
        if (verificaAluno == null) return null;

        verificaAluno.setNome(novoAluno.getNome());
        verificaAluno.setEmail(novoAluno.getEmail());
        verificaAluno.setTelefone(novoAluno.getTelefone());

        return alunoService.salvarNovoAluno(verificaAluno);
    }




}
