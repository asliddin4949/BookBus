package interfaces.impl;

import interfaces.IPassenger;
import model.*;
import storage.Storage;

import java.util.Scanner;

import static storage.Storage.*;

public class PassengerService implements IPassenger {
    @Override
    public void showTravel() {
        travelList.forEach(System.out::println);
    }

    @Override
    public void showBuses() {
        Scanner scanner = new Scanner(System.in);
        showTravel();
        System.out.println("Enter Travel Id:");
        int travelId = scanner.nextInt();
        Travel choosenTravel = travelList.stream().filter(travel ->
                travel.getId() == travelId).findFirst().orElse(null);

        if (choosenTravel != null) {
            for (Travel travel : travelList) {
                if (travel.equals(choosenTravel)) {
                    System.out.println(travel.getBus());
                }
            }
        } else {
            System.out.println("Wrong Id!");
        }
    }

    @Override
    public void buyTicket(User passenger) {
        Scanner scanner = new Scanner(System.in);
        busList.forEach(System.out::println);
        System.out.println("Enter Bus Id:");
        int busId = scanner.nextInt();
        Bus chosenBus = busList.stream().filter(bus ->
                bus.getId() == busId).findFirst().orElse(null);
        if (chosenBus == null) {
            System.out.println("Wrong Id");
        } else {
            Travel travelOfBus = travelList.stream().filter(travel ->
                    travel.getBus().equals(chosenBus)).findFirst().orElse(null);
            if (travelOfBus != null) {
                orderTicket(passenger, travelOfBus);
            } else {
                System.out.println("This bus does not have any travels! Try Again!");
            }
        }
    }

    private void orderTicket(User passenger, Travel travel) {
        boolean flag = true;
        for (Ticket ticket : ticketList) {
            if (ticket.getTravel().equals(travel) && ticket.getStatus().equals(Status.AVAILABLE)) {
                System.out.println(ticket);
                flag = false;
            }
        }

        if (flag) {
            System.out.println("There is no Available Tickets now!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Ticket Id:");
            int ticketId = scanner.nextInt();
            Ticket chosenTicket = ticketList.stream().filter(ticket -> ticket.getId() == ticketId).findFirst().orElse(null);
            if (chosenTicket != null) {
                int checkBalance = passenger.getBalance().compareTo(chosenTicket.getPrice());
                if (checkBalance == -1) {
                    System.out.println("Not Enough Balance");
                } else {
                    orderList.add(new Order(Order.currentId, passenger, chosenTicket, chosenTicket.getPrice()));
                    for (User user : userList) {
                        if (user.equals(passenger)) {
                            user.setBalance(user.getBalance().subtract(chosenTicket.getPrice()));
                        }
                    }
                    for (Ticket ticket : ticketList) {
                        if(ticket.equals(chosenTicket)){
                            ticket.setStatus(Status.SOLD);
                        }
                    }
                    System.out.println("Thank you for your bought!");
                }
            } else {
                System.out.println("Wrong Id!");
            }
        }
    }

    @Override
    public void ticketHistory(User passenger) {
        for (Order order : orderList) {
            if (order.getUser().equals(passenger)) {
                System.out.println(order);
            }
        }
    }

    private static PassengerService passengerService;

    public static PassengerService getInstance() {
        if (passengerService == null) {
            passengerService = new PassengerService();
        }
        return passengerService;
    }
}
