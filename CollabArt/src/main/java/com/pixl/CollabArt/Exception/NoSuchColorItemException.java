package com.pixl.CollabArt.Exception;

public class NoSuchColorItemException extends RuntimeException {
    public NoSuchColorItemException() {
        System.err.println("No such color with given ID value ! ");
    }
}
