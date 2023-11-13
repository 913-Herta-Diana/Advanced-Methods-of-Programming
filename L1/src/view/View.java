package view;
import controller.Controller;
import model.Car;
import model.Moto;
import model.Truck;
import model.Vehicle;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Scanner;

public class View {
    Controller controller;
    public View(Controller ctr) {this.controller=ctr;}
    public void printMenu()
    {
        System.out.println("0. Exit");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Show all");
        System.out.println("4. Filter");
    }
    public void run()
    {
        boolean run=true;
        do{

            printMenu();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Your choice: ");
            String choice=scanner.nextLine();

            try {

                switch (choice) {
                    case "0":
                        run=false;
                        break;
                    case "1":
                            this.controller.addVehicle(new Car((float) 120.00));
                            this.controller.addVehicle(new Truck((float) 121.23));
                            this.controller.addVehicle(new Moto((float) 1020.10));

                        break;
                    case "2":
                            Vehicle v1 = new Moto((float) 1020.10);
                            this.controller.deleteVehicle(v1);
                        break;
                    case "3":
                        System.out.print("Registered vehicles: ");
                        for (Vehicle v : this.controller.getAll())
                            System.out.println(v.toString());
                        break;
                    case "4":
                        List<Vehicle> filteredVehicles = this.controller.filterExpensive();
                        for (Vehicle v : filteredVehicles)
                            System.out.println(v.toString());
                        break;
                    default:
                        System.out.println("Invalid command!");
                }
            }
            catch (InvalidObjectException e) {
                System.out.println("\u001B[31m\t" + e.getMessage() + "\u001B[0m");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        while(run==true);

    }
}
