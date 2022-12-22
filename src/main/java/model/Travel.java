package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Travel {
    int id;
    String name;
    String from;
    String to;
    Date date;
    Bus bus;
    User user;
    BigDecimal priceForPerSeat;

    public Travel(int id, String name, String from, String to, Date date, Bus bus, User user, BigDecimal priceForPerSeat) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.date = date;
        this.bus = bus;
        this.user = user;
        this.priceForPerSeat = priceForPerSeat;
    }

    @Override
    public String toString() {
        return "\nTravel Id: " + id +
                "\nName: " + name +
                "\nFrom:" + from +
                "\nTo: " + to +
                "\nDate: " + date +
                "\n" + bus +
                "\nDriver: " + user.getName() +
                "\nPrice For Per Seat=" + priceForPerSeat +
                "\n- - - - - - - - - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }

}
