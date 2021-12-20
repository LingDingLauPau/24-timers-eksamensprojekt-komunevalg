package com.kea.kommunalvalg.controller;

import com.kea.kommunalvalg.model.Kommunalpolitiker;
import com.kea.kommunalvalg.repository.KommunalpolitikerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kommunalpolitiker")
public class KommunalpolitikerController {

    @Autowired
    KommunalpolitikerRepo kommunalpolitikerRepo;


    //Get alle kommunalpolitikere
    @GetMapping
    public List<Kommunalpolitiker> getAllKommunalpolitiker(){
        return kommunalpolitikerRepo.findAll();
    }


    // Get en kommunalpolitiker med id
    @GetMapping("/{id}")
    public Kommunalpolitiker getKommunalpolitiker(@PathVariable int id){
        Optional<Kommunalpolitiker> kommunalpolitiker = kommunalpolitikerRepo.findById(id);
        if(kommunalpolitiker.isPresent()) {
            return kommunalpolitiker.get();
        }else throw new Error("Error: " + kommunalpolitiker + " eksistere ikke.");
    }

    //Get kommunalpolitikere udfra parti
    @GetMapping("/findShort/{partyShort}")
    public List<Kommunalpolitiker> getAllKommunalpolitikerFromPartyShort(@PathVariable String partyShort){
        return kommunalpolitikerRepo.findAllByPartyShort(partyShort);
    }

    //Get kommunalpolitikere udfra parti
    @GetMapping("/findName/{partyName}")
    public List<Kommunalpolitiker> getAllKommunalpolitikerFromPartyName(@PathVariable String partyName){
        return kommunalpolitikerRepo.findAllByPartyName(partyName);
    }

    //Update en kommunalpolitiker udfra id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateKommunalpolitiker(@PathVariable int id, @RequestBody Kommunalpolitiker kommunalpolitiker){
        kommunalpolitiker.setId(id);
        kommunalpolitikerRepo.save(kommunalpolitiker);
        return ResponseEntity.noContent().build();
    }

    // Jeg har taget udgangspunkt i dette POST eksempel https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
    // Create en kommunalpolitiker
    @PostMapping("/")
    public ResponseEntity<Object> createKommunalpolitiker(@RequestBody Kommunalpolitiker kommunalpolitiker) {
        Kommunalpolitiker kommunalpolitikerToSave = kommunalpolitikerRepo.save(kommunalpolitiker);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(kommunalpolitikerToSave.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    //Delete en specifik kommunalpolitiker ved hjælp af id
    @DeleteMapping("/{id}")
    public String deleteKommunalpolitiker(@PathVariable int id){
        kommunalpolitikerRepo.deleteById(id);
        return "Kommunalpolitiker med id:" + id + " blev slettet";
    }


}
