package com.petshop.scopisto.model.Exceptions;

public class UserStoreIsFULLException extends RuntimeException{
    public UserStoreIsFULLException(String FirstName,String LastName) {
        super(String.format("User with FirstName: %s LastName: %s can't be added because the store is full",FirstName,LastName));
    }
}

