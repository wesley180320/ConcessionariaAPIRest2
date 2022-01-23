package com.example.salve.demo.Repository;

import com.example.salve.demo.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
