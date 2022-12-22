package console;

import interfaces.Console;
import interfaces.impl.PassengerService;
import model.User;

import java.util.Scanner;

public class PassengerConsole implements Console {
    @Override
    public void openConsole(User passenger) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - show travels  '2' - show buses  '0' - exit" +
                    "\n'3' - buy ticket  '4' - ticket history");
            int command = scanner.nextInt();
            if (command == 1) {
                PassengerService.getInstance().showTravel();
            } else if (command == 2) {
                PassengerService.getInstance().showBuses();
            } else if (command == 3) {
                PassengerService.getInstance().buyTicket(passenger);
            } else if (command == 4) {
                PassengerService.getInstance().ticketHistory(passenger);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }

        }

    }

    private static PassengerConsole passengerConsole;

    public static PassengerConsole getInstance() {
        if (passengerConsole == null) {
            passengerConsole = new PassengerConsole();
        }
        return passengerConsole;
    }
}
