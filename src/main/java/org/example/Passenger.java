package org.example;

public abstract class Passenger {
    private Passenger boss;
    private Micro micro;

    void subir(Micro micro) throws CannotGetInException {
        if (this.evaluateMicro(micro)) this.micro = micro;
        else throw new CannotGetInException();
    };

    abstract boolean evaluateMicro(Micro micro);
}
