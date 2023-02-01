package org.example;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void apurado() throws InconsistentCapacityException, CannotGetInException {
        Passenger passenger = new Apurado();

        Micro micro = new Micro(100, 30, 10);

        Boolean evaluation = micro.canGetIn(passenger);
        Assertions.assertTrue(evaluation);
    }

    @Test
    void claustrofobico() throws InconsistentCapacityException, CannotGetInException {
        Passenger passenger = new Claustrofobico();
        Micro micro = new Micro(130, 30, 10);

        Boolean evaluation = micro.canGetIn(passenger);
        Assertions.assertTrue(evaluation);
    }

    @Test
    void claustrofobicoInSmallMicro() throws InconsistentCapacityException, CannotGetInException {
        Passenger passenger = new Claustrofobico();
        Micro micro = new Micro(100, 30, 10);

        CannotGetInException exception = Assertions.assertThrows(CannotGetInException.class, () -> micro.canGetIn(passenger));
        String expectedMessage = "Micro does not comply with passenger specifications";
        String message = exception.getMessage();

        Assertions.assertTrue(message.equals(expectedMessage));
    }

    @Test
    void fiaca() throws InconsistentCapacityException, CannotGetInException {
        Passenger passenger = new Fiaca();
        Micro micro = new Micro(100, 30, 1);

        Boolean evaluation = micro.canGetIn(passenger);
        Assertions.assertTrue(evaluation);
    }

    @Test
    void fiacaMicroLLeno() throws InconsistentCapacityException {
        Passenger passenger = new Fiaca();
        Passenger jorge = new Apurado();
        Passenger amanda = new Apurado();

        Micro micro = new Micro(100, 30, 2);

        micro.addPassenger(jorge);
        micro.addPassenger(amanda);

        CannotGetInException exception = Assertions.assertThrows(CannotGetInException.class, () -> micro.canGetIn(passenger));
        String expectedMessage = "Micro does not comply with passenger specifications";
        String message = exception.getMessage();

        Assertions.assertTrue(message.equals(expectedMessage));
    }

    @Test
    void moderado() throws InconsistentCapacityException, CannotGetInException {
        Passenger passenger = new Moderado(2);
        Micro micro = new Micro(100, 3, 1);

        Boolean evaluation = micro.canGetIn(passenger);
        Assertions.assertTrue(evaluation);
    }

    @Test
    void moderadoCannotGetIn() throws InconsistentCapacityException {
        Passenger passenger = new Moderado(2);

        Micro micro = new Micro(100, 1, 1);

        Passenger jorge = new Apurado();
        micro.addPassenger(jorge);

        CannotGetInException exception = Assertions.assertThrows(CannotGetInException.class, () -> micro.canGetIn(passenger));

        String expectedMessage = "Micro does not comply with passenger specifications";
        String message = exception.getMessage();

        Assertions.assertTrue(message.equals(expectedMessage));
    }

    @Test
    void microInconsistentCapacity() {
        InconsistentCapacityException exception = Assertions.assertThrows(InconsistentCapacityException.class, () -> new Micro(100, 4, 5));
        String expectedMessage = "Sitting capacity cannot be higher than total capacity";
        String message = exception.getMessage();

        Assertions.assertTrue(message.equals(expectedMessage));
    }

    @Test
    void obsecuente() throws InconsistentCapacityException, CannotGetInException {
        Passenger jefe = new Fiaca();
        Passenger passenger = new Obsecuente(jefe);

        Micro micro = new Micro(100, 30, 1);

        Boolean evaluation = micro.canGetIn(passenger);
        Assertions.assertTrue(evaluation);
    }

    @Test
    void obsecuenteJefeFiacaNoSitting() throws InconsistentCapacityException {
        Passenger jefe = new Fiaca();
        Passenger passenger = new Obsecuente(jefe);

        Passenger jorge = new Apurado();
        Passenger amanda = new Apurado();

        Micro micro = new Micro(100, 30, 2);

        micro.addPassenger(jorge);
        micro.addPassenger(amanda);

        CannotGetInException exception = Assertions.assertThrows(CannotGetInException.class, () -> micro.canGetIn(passenger));
        String expectedMessage = "Micro does not comply with passenger specifications";
        String message = exception.getMessage();

        Assertions.assertTrue(message.equals(expectedMessage));
    }
}
