package com.petshop.scopisto.repository;


import com.petshop.scopisto.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pet,Long>{
}