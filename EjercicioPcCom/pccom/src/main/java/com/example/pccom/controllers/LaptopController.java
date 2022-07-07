package com.example.pccom.controllers;


import com.example.pccom.entities.Laptop;
import com.example.pccom.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepository;

    //Creo los constructores
    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    //Comienzo a crear los CRUD
    //Buscar las Laptops

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }



    //Buscar Laptop por ID
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    //Crear Laptop en base de datos
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        //Comprobamos si existe el ID, por tanto no es un creacion
        if(laptop.getLapId() != null){
            log.warn("Trying to update a non existent Laptop");
            return ResponseEntity.badRequest().build();
        }
        //Guardamos los datos recibidos por parametro en la bd
    Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
        //Guardamos los datos recibidos por parametro en la bd


    }

    //Actualizamos los datos en la DDBB
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        //Comprobamos si no existe el ID
        if(laptop.getLapId() == null){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();

        }
            //Comprobamos si existe el ID, se comprueba solo por ID
        if(!laptopRepository.existsById(laptop.getLapId())){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        //En caso de que pase las comprobaciones hacemos el update
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar solo una laptop por ID
   // @ApiIgnore
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borramos todas las laptops de la base de datos
   // @ApiIgnore
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
