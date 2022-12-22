package interfaces;

import model.User;

public interface IPassenger {
    void showTravel();

    void showBuses();

    void buyTicket(User passenger);

    void ticketHistory(User passenger);

}
