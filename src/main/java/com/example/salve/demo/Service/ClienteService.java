package com.example.salve.demo.Service;

import com.example.salve.demo.Domain.Cliente;
import com.example.salve.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){

        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElse(null);
    }


    public List<Cliente> findAll(){

        return clienteRepository.findAll();
    }


    public void deleteById(Integer id){

        clienteRepository.deleteById(id);
    }

    public Cliente save(Cliente obj){

        return clienteRepository.save(obj);
    }


}
