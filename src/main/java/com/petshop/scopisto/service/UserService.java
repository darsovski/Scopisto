package com.petshop.scopisto.service;

import com.petshop.scopisto.model.Dto.PetDto;
import com.petshop.scopisto.model.Dto.UserDto;
import com.petshop.scopisto.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User createUser(String FirstName,String LastName,String email, Integer money);
    List<User> findAll();
    Optional<User> save(UserDto userDto);
    void buyPet(UserDto userDto, PetDto petDto);
    // buy;

}
