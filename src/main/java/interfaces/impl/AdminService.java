package interfaces.impl;

import interfaces.IAdmin;
import lombok.SneakyThrows;
import model.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static storage.Storage.*;

public class AdminService implements IAdmin {
    @Override
    public void addBus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Number: ");
        String number = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("NumberOfSeats: ");
        int numberSeats = scanner.nextInt();
        busList.add(new Bus(Bus.currentId, name, number, numberSeats));
        System.out.println("Bus Added!");
    }

    @Override
    public void addDriver() {
        User driver = Registration.getInstance().SignUp();
        if (driver != null) {
            for (User user : userList) {
                if (user.equals(driver)) {
                    user.setRole(Role.DRIVER);
                }
            }
            System.out.println("Driver Added!");
        } else {
            System.out.println("Something went wrong!");
        }

    }

    @SneakyThrows
    @Override
    public void addTravel() {
        Scanner scanner = new Scanner(System.in);
        busList.forEach(System.out::println);
        System.out.println("Bus Id:");
        int busId = scanner.nextInt();
        for (User user : userList) {
            if (user.getRole().equals(Role.DRIVER)) {
                System.out.println(user);
            }
        }
        System.out.println("Driver Id:");
        int driverId = scanner.nextInt();
        Bus chooseBus = busList.stream().filter(bus -> bus.getId() == busId).findFirst().orElse(null);
        User driver = userList.stream().filter(user -> user.getId() == driverId).findFirst().orElse(null);
        if (chooseBus != null && driver != null) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            scanner = new Scanner(System.in);
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("From:");
            String from = scanner.nextLine();
            System.out.println("To");
            String to = scanner.nextLine();
            System.out.println("Date:");
            String date = scanner.nextLine();
            System.out.println("PriceForPerSeat: ");
            BigDecimal price = scanner.nextBigDecimal();
            Date travelDate = dateFormat.parse(date);

            Travel checkTravel = travelList.stream().filter(travel ->
                    travel.getBus().equals(chooseBus)).findFirst().orElse(null);

            if (checkTravel == null) {
                Travel travel = new Travel(Travel.currentId, name, from, to, travelDate, chooseBus, driver, price);
                travelList.add(travel);

                for (int i = 1; i <= chooseBus.getNumberOfSeats(); i++) {
                    ticketList.add(new Ticket(Ticket.currentId, travel, price, i, Status.AVAILABLE));
                }

                System.out.println("Travel Added!");
            } else {
                System.out.println("This bus is busy now!");
            }

        } else {
            System.out.println("Wrong Id!");
        }

    }

    @Override
    public void showBusStatus() {
        Scanner scanner = new Scanner(System.in);
        busList.forEach(System.out::println);
        int busId = scanner.nextInt();
        Bus choosenBus = busList.stream().filter(bus -> bus.getId() == busId).findFirst().orElse(null);

        if (choosenBus == null) {
            System.out.println("Wrong Id!");
        } else {

            Travel choosenTravel = travelList.stream().filter(travel ->
                    travel.getBus().equals(choosenBus)).findFirst().orElse(null);
            if (choosenTravel == null) {
                System.out.println("Wrong Id!");
            } else {
                for (Ticket ticket : ticketList) {
                    if (ticket.getTravel().equals(choosenTravel)) {
                        System.out.println(ticket);
                    }
                }
            }
        }
    }

    private static AdminService adminService;

    public static AdminService getInstance() {
        if (adminService == null) {
            adminService = new AdminService();
        }
        return adminService;
    }
}
