package repo;
import model.Vehicle;

import java.io.InvalidObjectException;

public interface Repo {
    void addVehicle(Vehicle vehicle) throws ArrayIndexOutOfBoundsException;
    void deleteVehicle(Vehicle vehicle) throws InvalidObjectException;
    Vehicle[] getAll();

    int getCurrentLen();
}
