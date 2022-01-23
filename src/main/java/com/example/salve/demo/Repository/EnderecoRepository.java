package com.example.salve.demo.Repository;

import com.example.salve.demo.Domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
