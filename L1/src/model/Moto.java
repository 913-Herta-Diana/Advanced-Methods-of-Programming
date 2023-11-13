package model;

public class Moto implements Vehicle{
    private float cost;
    public Moto(float repairCost) {this.cost = repairCost;}
    public Moto(){
        this(0);
    }
    @Override
    public float getRepairCost() {return this.cost;}

    @Override
    public String toString(){
        return "Moto( " + "cost=" + this.cost + " )";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moto otherCar = (Moto) obj;
        return this.cost==otherCar.getRepairCost();
    }
}
