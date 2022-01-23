package com.example.salve.demo.Resources;


import com.example.salve.demo.Domain.Cliente;
import com.example.salve.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){

        Cliente cli = clienteService.findById(id);

        return ResponseEntity.ok().body(cli);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById( @PathVariable Integer id){

        clienteService.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> findAll(){

        List<Cliente> clientes = clienteService.findAll();

        return ResponseEntity.ok().body(clientes);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Cliente> save( @RequestBody Cliente cli){

        Cliente obj = clienteService.save(cli);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
