package com.pixl.CollabArt.Exception;

public class NoSuchPixelException extends RuntimeException{


    public NoSuchPixelException() {
        System.err.println("No such pixel with given position values ! ");
    }
}
