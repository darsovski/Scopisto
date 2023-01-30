package com.petshop.scopisto.model.Dto;

import com.petshop.scopisto.Enum.Type;
import com.petshop.scopisto.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PetDto {


    @OneToOne
    private User owner;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type typeOfPet;

    private String description;
    private LocalDateTime dateOfBirth;
    private Integer price;
    private Double ratings;


    public PetDto() {};

    public PetDto(User owner, String name, Type typeOfPet, String description, LocalDateTime dateOfBirth, Integer price, Double ratings) {
        if(this.typeOfPet.equals(Type.Cat)) {
            this.owner=owner;
            this.name=name;
            this.typeOfPet=Type.Cat;
            this.description=description;
            this.dateOfBirth=dateOfBirth;
            this.price=price;
            this.ratings=0.0;
        } else if(this.typeOfPet.equals("Dog")) {
            this.owner=owner;
            this.name=name;
            this.typeOfPet=Type.Dog;
            this.description=description;
            this.dateOfBirth=dateOfBirth;
            this.price=price;
            this.ratings =  (Math.random()*(10 - 1));
        }
    }
}
