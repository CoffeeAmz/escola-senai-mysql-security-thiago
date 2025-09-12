package com.senai.escola.Controller;

import com.senai.escola.Models.Professor;
import com.senai.escola.Service.ProfessorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping
    public List<Professor> buscarProfessores(){
        return professorService.buscarTodosProfessores();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public Professor salvar(@RequestBody Professor professor){
        return professorService.salvarNovoProfessor(professor);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/{id}")
    public Professor atualizarProfessores(@PathVariable Long id,@RequestBody Professor novoProfessor){

        Professor verificaProfessor = professorService.buscarProfessorId(id);
        if (verificaProfessor == null) return null;

        verificaProfessor.setNome(novoProfessor.getNome());
        verificaProfessor.setEmail(novoProfessor.getEmail());
        verificaProfessor.setTelefone(novoProfessor.getTelefone());

        return professorService.salvarNovoProfessor(verificaProfessor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id){
        professorService.deletarProfessor(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Professor buscaAlunoPorId(@PathVariable Long id){
        return professorService.buscarProfessorId(id);
    }



}
