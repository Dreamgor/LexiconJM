package se.lexicon.jm.garage;

public abstract class Vehicle {
  //gemensamma variabler
  private int weight;
  private int parkSpot;

  //konstruktor
  public Vehicle(int weight, int parkSpot){
    this.weight = weight;
    this.parkSpot = parkSpot;
  }

  //getters
  public int getWeight() {
    return weight;
  }

  public int getParkSpot() {
    return parkSpot;
  }

  //toString
  @Override
  public String toString(){
    return " Vikt: " + weight + ". Parkeringsplats: " + parkSpot + ".";
  }
}
