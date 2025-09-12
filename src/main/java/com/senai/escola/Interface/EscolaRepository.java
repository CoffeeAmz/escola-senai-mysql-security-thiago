package com.senai.escola.Interface;

import com.senai.escola.Models.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
