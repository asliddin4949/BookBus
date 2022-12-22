package console;

import interfaces.Console;
import interfaces.impl.AdminService;
import model.User;

import java.util.Scanner;

public class AdminConsole implements Console {
    @Override
    public void openConsole(User user) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - add bus  '2' - add driver  '0' - exit"
                    + "\n'3' - add travel  '4' show bus status");
            int command = scanner.nextInt();

            if (command == 1) {
                AdminService.getInstance().addBus();
            } else if (command == 2) {
                AdminService.getInstance().addDriver();
            } else if (command == 3) {
                AdminService.getInstance().addTravel();
            } else if (command == 4) {
                AdminService.getInstance().showBusStatus();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }

        }


    }

    private static AdminConsole adminConsole;

    public static AdminConsole getInstance() {

        if (adminConsole == null) {
            adminConsole = new AdminConsole();
        }
        return adminConsole;
    }
}
