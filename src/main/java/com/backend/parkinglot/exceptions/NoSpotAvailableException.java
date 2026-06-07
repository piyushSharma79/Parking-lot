package com.backend.parkinglot.exceptions;

public class NoSpotAvailableException extends Throwable {

    public NoSpotAvailableException() {
        System.out.println("No spot available at the moment");
    }
}
