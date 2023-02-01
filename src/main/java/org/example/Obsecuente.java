package org.example;

public class Obsecuente extends Passenger {
    Passenger jefe;
    public Obsecuente(Passenger jefe) {
        this.jefe = jefe;
    }

    @Override
    boolean evaluateMicro(Micro micro) {
        return this.jefe.evaluateMicro(micro);
    }
}
