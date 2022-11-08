package com.transporters.truckservice.exceptions;

public class NonEmptyDepotException extends  RuntimeException{

    public  NonEmptyDepotException(String error){
        super(error);
    }
}
