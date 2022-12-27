package com.pixl.CollabArt.Exception;

public class NoSuchCanvasElementException extends RuntimeException {
    public NoSuchCanvasElementException() {
        System.err.println("No such canvas element with given ID value !");
    }
}
