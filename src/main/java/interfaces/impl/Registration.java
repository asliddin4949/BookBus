package interfaces.impl;

import console.AdminConsole;
import console.DriverConsole;
import console.PassengerConsole;
import interfaces.IRegistration;
import model.Role;
import model.User;

import java.math.BigDecimal;
import java.util.Scanner;

import static storage.Storage.admin;
import static storage.Storage.userList;


public class Registration implements IRegistration {
    @Override
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        User signInUser = userList.stream().filter(user ->
                        user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst().orElse(null);

        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            AdminConsole.getInstance().openConsole(admin);
        } else if (signInUser == null) {
            System.out.println("Wrong Username or Password");
        } else if (signInUser.getRole().equals(Role.PASSENGER)) {
            System.out.println("Welcome " + signInUser.getName() + '!');
            PassengerConsole.getInstance().openConsole(signInUser);
        } else {
            System.out.println("Welcome " + signInUser.getName() + '!');
            DriverConsole.getInstance().openConsole(signInUser);
        }

    }

    @Override
    public User SignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        var checkUser = userList.stream().filter(user ->
                user.getUsername().equals(username)).findFirst().orElse(null);
        if (checkUser == null) {
            scanner = new Scanner(System.in);
            System.out.println("Password:");
            String password = scanner.nextLine();
            System.out.println("Name:");
            String name = scanner.nextLine();
            User user = new User(User.currentId, name, username, password, Role.PASSENGER, BigDecimal.valueOf(150000));
            userList.add(user);
            System.out.println("Signed Up");
            return user;
        } else {
            System.out.println("This username has already signed up");
            return checkUser;
        }
    }

    private static Registration registration;

    public static Registration getInstance() {

        if (registration == null) {
            registration = new Registration();
        }
        return registration;
    }
}
