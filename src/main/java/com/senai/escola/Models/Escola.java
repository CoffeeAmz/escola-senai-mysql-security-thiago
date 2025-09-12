//package com.senai.escola.Models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Escola {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
//
//   private String nome;
//   private String email;
//   private String telefone;
//
//   private String cnpj;
//   private String componentes;
//   private String turmas;
//   private Boolean statusAluno;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getCnpj() {
//        return cnpj;
//    }
//
//    public void setCnpj(String cnpj) {
//        this.cnpj = cnpj;
//    }
//
//    public String getComponentes() {
//        return componentes;
//    }
//
//    public void setComponentes(String componentes) {
//        this.componentes = componentes;
//    }
//
//    public String getTurmas() {
//        return turmas;
//    }
//
//    public void setTurmas(String turmas) {
//        this.turmas = turmas;
//    }
//
//    public Boolean getStatusAluno() {
//        return statusAluno;
//    }
//
//    public void setStatusAluno(Boolean statusAluno) {
//        this.statusAluno = statusAluno;
//    }
//}
package com.senai.escola.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private String email;
   private String telefone;

   private String cnpj;
   private String componentes;
   private String turmas;
   private Boolean statusAluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getTurmas() {
        return turmas;
    }

    public void setTurmas(String turmas) {
        this.turmas = turmas;
    }

    public Boolean getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(Boolean statusAluno) {
        this.statusAluno = statusAluno;
    }
}
