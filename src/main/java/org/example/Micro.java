package org.example;

import java.util.ArrayList;

public class Micro {
    public ArrayList<Passenger> sitting = new ArrayList<Passenger>();
    public ArrayList<Passenger> standing = new ArrayList<Passenger>();
    public Integer volume;
    public Integer sittingCapacity;
    public Integer capacity;

    public Micro(Integer volume, Integer capacity, Integer sittingCapacity) throws InconsistentCapacityException {
        if (sittingCapacity > capacity) {
            throw new InconsistentCapacityException();
        }
        this.volume = volume;
        this.capacity = capacity;
        this.sittingCapacity = sittingCapacity;
    }

    public Boolean canGetIn(Passenger passenger) throws CannotGetInException {
        if (passenger.evaluateMicro(this)) return true;
        else throw new CannotGetInException();
    }

    public void addPassenger(Passenger passenger) {
        if (sitting.size() < sittingCapacity) sitting.add(passenger);
        else standing.add(passenger);
    }
}
