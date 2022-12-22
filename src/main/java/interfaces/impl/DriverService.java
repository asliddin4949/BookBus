package interfaces.impl;

import interfaces.IDriver;
import model.Travel;
import model.User;
import storage.Storage;

import static storage.Storage.travelList;

public class DriverService implements IDriver {

    @Override
    public void showTravels(User driver) {

        for (Travel travel : travelList) {
            if (travel.getUser().equals(driver)) {
                System.out.println(travel);
            }
        }
    }

    private static DriverService driverService;

    public static DriverService getInstance() {
        if (driverService == null) {
            driverService = new DriverService();
        }
        return driverService;
    }
}
