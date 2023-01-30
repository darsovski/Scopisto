package com.petshop.web.rest;


import com.petshop.scopisto.model.Dto.PetDto;
import com.petshop.scopisto.model.Dto.UserDto;
import com.petshop.scopisto.model.Pet;
import com.petshop.scopisto.model.User;
import com.petshop.scopisto.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/pets")
public class PetRestController {


    private final PetService petService;

    public PetRestController (PetService petService) { this.petService = petService;}

    @GetMapping
    private List<Pet> findAll() { return this.petService.findAll(); };

    @PostMapping("/add")
    public ResponseEntity<Pet> save(@RequestBody PetDto petDto) {

        return this.petService.save(petDto)
                .map(pet -> ResponseEntity.ok().body(pet))
                .orElseGet( () -> ResponseEntity.badRequest().build());
    }

}
