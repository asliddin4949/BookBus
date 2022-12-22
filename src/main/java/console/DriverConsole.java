package console;

import interfaces.Console;
import interfaces.impl.DriverService;
import model.User;

import java.util.Scanner;

public class DriverConsole implements Console {
    @Override
    public void openConsole(User driver) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - show my travels  '0' - exit");
            int command = scanner.nextInt();
            if (command == 1) {
                DriverService.getInstance().showTravels(driver);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong Command!");
            }
        }
    }

    private static DriverConsole driverConsole;

    public static DriverConsole getInstance() {
        if (driverConsole == null) {
            driverConsole = new DriverConsole();
        }
        return driverConsole;
    }
}
