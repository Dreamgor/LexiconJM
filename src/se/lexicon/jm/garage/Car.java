package se.lexicon.jm.garage;

public class Car extends Vehicle {

  //konstruktor och unik variabel
  private double fuelEfficency;
  public Car(int weight, int parkSpot, double fuelEfficency) {
    super(weight, parkSpot);
    this.fuelEfficency = fuelEfficency;
  }

  public double getFuelEfficency() {
    return fuelEfficency;
  }

  //toString

  @Override
  public String toString() {
    return super.toString() + " Bränsleeffektivitet: " + fuelEfficency + ". ";
  }
}
