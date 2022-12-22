package storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    public static User admin = new User("admin","123");
    public static List<User> userList = new ArrayList<>();
    public static List<Bus> busList = new ArrayList<>();
    public static List<Travel> travelList = new ArrayList<>();
    public static List<Ticket> ticketList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();

}
