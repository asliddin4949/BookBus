package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Getter
@Setter
@EqualsAndHashCode
public class Ticket {
    int id;
    Travel travel;
    BigDecimal price;
    int seatNumber;
    Status status;

    public Ticket(int id, Travel travel, BigDecimal price, int seatNumber, Status status) {
        this.id = id;
        this.travel = travel;
        this.price = price;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    @Override
    public String toString() {
        return "\nTicket Id: " + id +
                "\nTravel Name: " + travel.getName() +
                "\nFrom"+travel.getFrom()+
                "\nTo"+travel.getTo()+
                "\nDate: "+dateFormat.format(travel.getDate())+
                "\nBus Number: "+travel.getBus().getNumber()+
                "\nPrice: " + price +
                "\nSeat Number: " + seatNumber +
                "\nStatus: " + status +
                "\n- - - - - - - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
