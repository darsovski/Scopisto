package com.petshop.scopisto.model;

import com.petshop.scopisto.Enum.Type;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pets_table")
public class Pet {


    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private String id;

    @OneToOne
    private User owner;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type typeOfPet;

    private String description;
    private LocalDateTime dateOfBirth;
    private Integer price;
    private Double ratings;


    public Pet() {};

    public Pet(User owner, String name, Type typeOfPet, String description, LocalDateTime dateOfBirth, Integer price, Double ratings) {
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

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Type getTypeOfPet() {
        return typeOfPet;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public double getPrice() {

        LocalDateTime dateTime = LocalDateTime.now();
        int year = dateOfBirth.getYear();
        int currentYear = dateTime.getYear();

        if(typeOfPet.name().equals("Cat"))
            return (currentYear-year);
        else if (typeOfPet.name().equals("Dog"))
            return ((currentYear-year) + (ratings*1));

        return 0.0;
    }

    public double getRatings() {
        return ratings;
    }
}
