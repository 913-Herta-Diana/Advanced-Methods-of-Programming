package model;

public class Car implements Vehicle {

    private float cost;

    public Car(float repairCost) {
        this.cost = repairCost;
    }

    public Car() {
        this(0);
    }

    @Override
    public float getRepairCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "Car( " + "cost=" + this.cost + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car otherCar = (Car) obj;
        return this.cost == otherCar.getRepairCost(); //instanceof
    }
}

