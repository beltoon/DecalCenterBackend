package com.tobias.decalcenter.exceptions;

public class EmailExistsException extends RuntimeException{

        public EmailExistsException(String username){
            super("This email already exists");
        }
    }
