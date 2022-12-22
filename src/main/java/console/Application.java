package console;

import interfaces.IApplication;
import interfaces.impl.Registration;

import java.util.Scanner;

public class Application implements IApplication {
    @Override
    public void startApplication() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - sign in  '2' - sign up  '0' - exit");
            int command = scanner.nextInt();

            if (command == 1) {
                Registration.getInstance().signIn();
            } else if (command == 2) {
                Registration.getInstance().SignUp();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }
    }


    private static Application application;

    public static Application getInstance() {
        if (application == null) {
            application = new Application();
        }
        return application;

    }
}
