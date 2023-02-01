package org.example;

public class Fiaca extends Passenger {
    @Override
    boolean evaluateMicro(Micro micro) {
        return micro.sittingCapacity > micro.sitting.size();
    }
}
