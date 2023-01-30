package com.petshop.scopisto.service.implementation;


import com.petshop.scopisto.model.Dto.PetDto;
import com.petshop.scopisto.model.Dto.UserDto;
import com.petshop.scopisto.model.Exceptions.UserLowBudgetException;
import com.petshop.scopisto.model.Exceptions.UserStoreIsFULLException;
import com.petshop.scopisto.model.Exceptions.UserStoreIsFULLException;
import com.petshop.scopisto.model.User;
import com.petshop.scopisto.repository.PetsRepository;
import com.petshop.scopisto.repository.UserRepository;
import com.petshop.scopisto.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final PetsRepository petsRepository;
    public  int maxUsers=0;

    public UserServiceImplementation(UserRepository userRepository, PetsRepository petsRepository) {
        this.userRepository=userRepository;
        this.petsRepository=petsRepository;
    }


    @Override
    public User createUser(String FirstName, String LastName, String email, Integer money) {
        if(maxUsers>10) {
            User user = new User(FirstName,LastName,email,money);
            this.maxUsers++;

            return userRepository.save(user);
        }
        throw new UserStoreIsFULLException(FirstName,LastName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(UserDto userDto) {
        if(maxUsers>10) {
           // User user = new User(FirstName,LastName,email,money);
            this.maxUsers++;

            return Optional.of(userRepository.save(new User(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getMoney())));
        }
        throw new UserStoreIsFULLException(userDto.getFirstName(),userDto.getLastName());
    }

    @Override
    public void buyPet(UserDto userDto,PetDto petDto) {
        if(userDto.getMoney() < petDto.getPrice()) {
            throw new UserLowBudgetException(userDto.getFirstName(),userDto.getLastName(),petDto.getPrice()-userDto.getMoney());
        }
    }
}
