package com.petshop.scopisto.model.Exceptions;

import com.petshop.scopisto.model.User;

public class UserLowBudgetException extends RuntimeException {
    public UserLowBudgetException(String FirstName, String LastName, Integer money) {
        super((String.format("User %s %s doesn't have enough money, you need still",FirstName,LastName,money)));
    }
}

