package com.petshop.scopisto.model.Exceptions;

import com.petshop.scopisto.model.User;

public class PetAlreadyHasOwnerException extends RuntimeException {
    public PetAlreadyHasOwnerException(User owner) {
        super(String.format("Can't buy a pet who already has a owner: %s",owner));
    }

}


