package com.tobias.decalcenter.exceptions;

public class UserNameExistsException extends RuntimeException{

    public UserNameExistsException(String username){
        super("Username '" + username + "' already exists");
    }
}
