package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Order {
    int id;
    User user;
    Ticket ticket;
    BigDecimal sum;

    public Order(int id, User user, Ticket ticket, BigDecimal sum) {
        this.id = id;
        this.user = user;
        this.ticket = ticket;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "\nOrder Id: " + id +
                "\n" + user +
                "\n" + ticket +
                "\nCost: " + sum +
                "\n- - - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
