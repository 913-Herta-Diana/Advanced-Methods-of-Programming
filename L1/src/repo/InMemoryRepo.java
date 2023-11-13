package repo;

import model.Vehicle;

import java.io.InvalidObjectException;

public class InMemoryRepo implements Repo {
    Vehicle[] vehicles;
    int len;

    public InMemoryRepo() {
        this.vehicles = new Vehicle[10];
        len = 0;
    }

    @Override
    public void addVehicle(Vehicle vehicleToAdd) throws ArrayIndexOutOfBoundsException {

        if (len == vehicles.length)
            throw new ArrayIndexOutOfBoundsException();
        vehicles[len++] = vehicleToAdd; //exception

    }

    @Override
    public void deleteVehicle(Vehicle vehicleToDelete) throws InvalidObjectException {

        if (len < 0)
            throw new ArrayIndexOutOfBoundsException();

        // Create a new array with one less element
        Vehicle[] newArray = new Vehicle[10];

        // Copy elements from the original array to the new array, excluding the element at the specified index
        int newIndex = 0;
        int newLen = len;
        for (int i = 0; i < len; i++) {
            if (!vehicleToDelete.equals(vehicles[i])) {
                newArray[newIndex] = vehicles[i];
                newIndex++;
            } else newLen--;
        }
        if (newLen == len)
            throw new InvalidObjectException("Vehicle doesn't exists!");
        vehicles = newArray;
        len = newLen;
    }

    @Override
    public Vehicle[] getAll() {
        return vehicles;
    }

    @Override
    public int getCurrentLen() {
        return this.len;
    }
}
