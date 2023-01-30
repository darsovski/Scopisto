package com.petshop.scopisto.service.implementation;


import com.petshop.scopisto.Enum.Type;
import com.petshop.scopisto.model.Dto.PetDto;
import com.petshop.scopisto.model.Exceptions.PetAlreadyHasOwnerException;
import com.petshop.scopisto.model.Pet;
import com.petshop.scopisto.model.User;
import com.petshop.scopisto.repository.PetsRepository;
import com.petshop.scopisto.service.PetService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImplementation implements PetService {

    private final PetsRepository petsRepository;

    public PetServiceImplementation(PetsRepository petsRepository )  {
        this.petsRepository=petsRepository;
    }

    @Override
    public Pet createPet(User owner, String name, Type typeOfPet, String description, LocalDateTime dateOfBirth, Integer price, Double ratings) {
        Pet pet = new Pet(owner,name,typeOfPet,description,dateOfBirth,price,ratings);

        if(owner!=null) {
            throw new PetAlreadyHasOwnerException(owner);
        }
        return petsRepository.save(pet);
    }

    @Override
    public Optional<Pet> save(PetDto petDto) {
        return Optional.of(petsRepository.save(new Pet(petDto.getOwner(),petDto.getName(),petDto.getTypeOfPet(),petDto.getDescription(),petDto.getDateOfBirth(),petDto.getPrice(),petDto.getRatings())));
    }

    @Override
    public List<Pet> findAll() {
        return petsRepository.findAll();
    }
}
