package com.example.salve.demo.Resources;

import com.example.salve.demo.Domain.Carro;
import com.example.salve.demo.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/carro")
public class CarroResource {


    @Autowired
    private CarroService carroService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carro> findById( @PathVariable Integer id){

        Carro carro = carroService.FindByid(id);

        return ResponseEntity.ok().body(carro);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delet(@PathVariable Integer id){

         carroService.deletById(id);

         return ResponseEntity.ok().build();

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Carro>> findAll(@RequestBody Carro carro){

        List<Carro> obj = carroService.findAll();

        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public ResponseEntity<Carro> save(Carro carro){

       Carro obj = carroService.save(carro);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}

