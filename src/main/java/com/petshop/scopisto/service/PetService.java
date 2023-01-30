package com.petshop.scopisto.service;

import com.petshop.scopisto.Enum.Type;
import com.petshop.scopisto.model.Dto.PetDto;
import com.petshop.scopisto.model.Pet;
import com.petshop.scopisto.model.User;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PetService {


    Pet createPet(User owner, String name, Type typeOfPet, String description, LocalDateTime dateOfBirth, Integer price, Double ratings);
    Optional<Pet> save(PetDto petDto);
    List<Pet> findAll();
}
