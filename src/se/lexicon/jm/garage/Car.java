package se.lexicon.jm.garage;

public class Car extends Vehicle {

  //konstruktor och unik variabel
  private double fuelEfficency;
  public Car(int weight, int parkSpot, double fuelEfficency) {
    super(weight, parkSpot);
    setFuelEfficency(fuelEfficency);
  }

  public double getFuelEfficency() {
    return fuelEfficency;
  }

  //Setter

  public void setFuelEfficency(double fuelEfficency) {
    if(fuelEfficency < 0 && fuelEfficency != -2){
      throw new IllegalArgumentException("Skriv inte ett nummer under 0.");
    }
    this.fuelEfficency = fuelEfficency;

  }


  //toString

  @Override
  public String toString() {
    return super.toString() + " Bränsleeffektivitet: " + fuelEfficency + ". ";
  }
}
