package com.petshop.scopisto.model.Dto;


import lombok.Data;

@Data
public class UserDto {

    private String FirstName;
    private String LastName;
    private String email;
    private Integer money;

    public UserDto() {};

    public UserDto(String FirstName,String LastName,String email, Integer money) {
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.email=email;
        this.money=money;
    }
}
