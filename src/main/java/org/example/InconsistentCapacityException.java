package org.example;

public class InconsistentCapacityException extends Exception {
    public InconsistentCapacityException () {
        super("Sitting capacity cannot be higher than total capacity");
    }
}
