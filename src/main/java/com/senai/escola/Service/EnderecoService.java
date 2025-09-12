//package com.senai.escola.Service;
//
//
//import com.senai.escola.Interface.EnderecoRepository;
//import com.senai.escola.Models.Endereco;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EnderecoService {
//    private final EnderecoRepository repository;
//
//    public EnderecoService(EnderecoRepository repository) {
//        this.repository = repository;
//    }
//
//
//    public List<Endereco> buscarEndereco(){
//        return repository.findAll();
//    }
//
//    public Endereco salvarEndereco(Endereco endereco){
//        return repository.save(endereco);
//    }
//
//    public Endereco buscarEnderecoId(Long id){
//        return repository.findById(id).orElse(null);
//    }
//
//
//    public void deletarEndereco(Long id){
//        repository.deleteById(id);
//    }
//
//}
