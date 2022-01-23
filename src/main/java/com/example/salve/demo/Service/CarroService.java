package com.example.salve.demo.Service;

import com.example.salve.demo.Domain.Carro;
import com.example.salve.demo.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public Carro FindByid(Integer id){

        Optional<Carro> obj = carroRepository.findById(id);

        return obj.orElse(null);
    }

    public void deletById(Integer id){

      carroRepository.deleteById(id);
    }

    public List<Carro> findAll(){

        return carroRepository.findAll();
    }

    public Carro save(Carro carro){

        return carroRepository.save(carro);
    }
}
