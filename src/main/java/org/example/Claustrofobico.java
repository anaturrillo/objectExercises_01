package org.example;

public class Claustrofobico extends Passenger {
    @Override
    boolean evaluateMicro(Micro micro) {
        return micro.volume > 120;
    }
}
