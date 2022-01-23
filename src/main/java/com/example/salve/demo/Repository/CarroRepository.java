package com.example.salve.demo.Repository;

import com.example.salve.demo.Domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}