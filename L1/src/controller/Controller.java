package controller;
import repo.Repo;
import model.Vehicle;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Repo repo;
    public Controller(Repo repository){this.repo=repository;}
    public void addVehicle(Vehicle vehicleToAdd) throws ArrayIndexOutOfBoundsException {this.repo.addVehicle(vehicleToAdd);}

    public void deleteVehicle(Vehicle vehicleToDelete) throws InvalidObjectException {this.repo.deleteVehicle(vehicleToDelete);}
    public List<Vehicle> filterExpensive() {
        List<Vehicle> filteredVehicles = new ArrayList<>();
         for (Vehicle vehicle: this.getAll()) {
            if (vehicle.getRepairCost() > 1000)
                filteredVehicles.add(vehicle);
        }

        return filteredVehicles;
    }
    public List<Vehicle> getAll()
    {
        List<Vehicle> vehicles= new ArrayList<>();
        for(int i=0;i<this.repo.getCurrentLen();i++)
        {
            vehicles.add(this.repo.getAll()[i]);
        }
        return vehicles;
    }
}

