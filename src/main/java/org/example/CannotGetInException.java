package org.example;

public class CannotGetInException extends Exception {
    public CannotGetInException() {
        super("Micro does not comply with passenger specifications");
    }
}
