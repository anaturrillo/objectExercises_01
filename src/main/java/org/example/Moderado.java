package org.example;

public class Moderado extends Passenger {
    public Integer freeSpacesRequired;
    public Moderado(Integer freeSpacesRequired) {
        this.freeSpacesRequired = freeSpacesRequired;
    }

    @Override
    boolean evaluateMicro(Micro micro) {
        Integer vacancy = micro.capacity - micro.standing.size() - micro.sitting.size();
        return vacancy >= this.freeSpacesRequired;
    }
}
