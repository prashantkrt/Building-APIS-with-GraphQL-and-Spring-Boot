package com.mylearning.grapghql.Helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException() {
        return new RuntimeException("Resource not found!!!");
    }
}
