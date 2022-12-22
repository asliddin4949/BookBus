package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Getter

public class Bus {
    int id;
    String name;
    String number;
    int numberOfSeats;

    public Bus(int id, String name, String number, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "\nBus Id" + id +
                "\nName: " + name +
                "\nNumber=" + number +
                "\nNumber Of Seats: " + numberOfSeats +
                "\n- - - - - - - - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
