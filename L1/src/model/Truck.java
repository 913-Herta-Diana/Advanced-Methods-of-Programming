package model;

public class Truck implements Vehicle{
    private float cost;
    public Truck(float repairCost) {this.cost = repairCost;}
    public Truck(){
        this(0);
    }
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Truck otherCar = (Truck) obj;
    return this.cost==otherCar.getRepairCost();
}
    @Override
    public float getRepairCost() {return this.cost;}

    @Override
    public String toString(){
        return "Truck( " + "cost=" + this.cost + " )";
    }
}
