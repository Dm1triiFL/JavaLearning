package org.example.part_9;

public class InvalidValueError extends RuntimeException {
    public InvalidValueError(String message) {
        super(message);
    }
}
